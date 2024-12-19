import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.singlepointsol.datavalidation.R
import com.singlepointsol.datavalidation.SignUpActivity
import com.singlepointsol.datavalidation.WelcomeActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signInButton: Button
    lateinit var signUpButton: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading views into Activity
        usernameEditText = findViewById(R.id.username_et)
        passwordEditText = findViewById(R.id.passwordSignIn_et)
        signInButton = findViewById(R.id.signIn_button)
        signUpButton = findViewById(R.id.signUp_button)

        // Setting Listeners
        signInButton.setOnClickListener(this)
        signUpButton.setOnClickListener(this)

        // Initializing SharedPreferences
        sharedPreferences = getSharedPreferences("DataValidation", MODE_PRIVATE)

        // Handling Edge-to-Edge Layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.signUp_button -> {
                    val signUpIntent = Intent(this, SignUpActivity::class.java)
                    startActivity(signUpIntent)
                }

                R.id.signIn_button -> {
                    if (sharedPreferences.contains("nameKey") && sharedPreferences.contains("passwordKey")) {
                        val username = usernameEditText.text.toString()
                        val password = passwordEditText.text.toString()
                        val storedEmail =
                            sharedPreferences.getString("emailKey", "")
                        val storedPassword =
                            sharedPreferences.getString("passwordKey", "")

                        if (username.isEmpty() || password.isEmpty()) {
                            Toast.makeText(
                                this,
                                "Enter the Username and Password",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        } else {


                            // Check if the credentials match
                            if (username == storedEmail && password == storedPassword) {
                                val signInIntent = Intent(this, WelcomeActivity::class.java)
                                startActivity(signInIntent)
                                finish() // Prevent going back to the main activity
                            } else {
                                Toast.makeText(this, "Invalid Data!!", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
        }
    }
}

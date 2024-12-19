package com.singlepointsol.wallpaperretrofit.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.wallpaperretrofit.Adapter.WallPaperAdapter
import com.singlepointsol.wallpaperretrofit.Class.RetrofitInstance
import com.singlepointsol.wallpaperretrofit.DataClass.WallpaperItem
import com.singlepointsol.wallpaperretrofit.DataClass.WallpaperResponse
import com.singlepointsol.wallpaperretrofit.Interface.WallpaperService
import com.singlepointsol.wallpaperretrofit.R
import com.singlepointsol.wallpaperretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var wallPaperRecyclerView: RecyclerView
    private lateinit var wallpaperItemList: ArrayList<WallpaperItem>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wallPaperRecyclerView = findViewById(R.id.card_recyclerView)
        wallPaperRecyclerView.layoutManager = GridLayoutManager(this, 3)

        wallpaperItemList = ArrayList()  // Initialize the list to avoid null

        // Fetch wallpapers
        fetchWallpapers()

        // Set up the RecyclerView adapter
        wallPaperRecyclerView.adapter = WallPaperAdapter(wallpaperItemList) { wallpaper ->
            // Handle the click to navigate to the LargeActivity
            val largeIntent = Intent(this@MainActivity, LargeActivity::class.java).apply {
                putExtra("WALLPAPER_DETAILS", wallpaper)
            }
            startActivity(largeIntent) // Start LargeActivity with the wallpaper details
        }

        // Handle edge-to-edge layout and system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun fetchWallpapers() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val retrofit = RetrofitInstance.getRetrofitInstance()
                val service = retrofit.create(WallpaperService::class.java)

                val response: Response<WallpaperResponse> = service.getWallpapers(
                    apiKey = "47626086-cb873d7b992d88489e8f9d0ad"
                )

                if (response.isSuccessful && response.body() != null) {
                    val wallpapers = response.body()!!.hits
                    wallpaperItemList.clear()
                    wallpaperItemList.addAll(wallpapers)
                    wallPaperRecyclerView.adapter?.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load wallpapers", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

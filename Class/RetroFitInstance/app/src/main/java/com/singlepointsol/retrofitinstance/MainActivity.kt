package com.singlepointsol.retrofitinstance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.singlepointsol.retrofitinstance.Class.RetrofitInstance
import com.singlepointsol.retrofitinstance.DataClass.AlbumItem
import com.singlepointsol.retrofitinstance.Interface.AlbumService
import com.singlepointsol.retrofitinstance.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the Retrofit service instance
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        // LiveData for Retrofit response with explicit type
        val responseLiveData = liveData<Response<List<AlbumItem>>> {
            val response = retrofitService.getAlbums()
            emit(response)
        }

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Observe the responseLiveData
        responseLiveData.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val albumList = response.body()
                if (!albumList.isNullOrEmpty()) {
                    albumList.forEach { albumItem ->
                        val albumTitle = "Album Title: ${albumItem.title}\n"
                        val albumUserID = "Album UserId: ${albumItem.userId} \n"
                        binding.titleTextView.append(albumTitle)
                        binding.userIdTextView.append(albumUserID)
                    }
                }
            } else {
                binding.titleTextView.text = "Errdor: ${response.code()}"
                binding.userIdTextView.text = "Error: ${response.code()}"
            }
        })
    }
}

package com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.Class.RetrofitInstance
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.DataClass.WallpaperItem
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.Interface.WallpaperService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WallpaperViewModel : ViewModel() {

    private val _wallpapers = MutableStateFlow<List<WallpaperItem>>(emptyList())
    val wallpapers: StateFlow<List<WallpaperItem>> = _wallpapers

    private val retrofitService: WallpaperService =
        RetrofitInstance.getRetrofitInstance().create(WallpaperService::class.java)

    init {
        fetchWallpapers()
    }

    private fun fetchWallpapers() {
        viewModelScope.launch {
            try {
                val response = retrofitService.getWallpapers(query = "wallpapers") // Example query
                if (response.isSuccessful) {
                    _wallpapers.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                // Handle error (e.g., logging)
            }
        }
    }
}

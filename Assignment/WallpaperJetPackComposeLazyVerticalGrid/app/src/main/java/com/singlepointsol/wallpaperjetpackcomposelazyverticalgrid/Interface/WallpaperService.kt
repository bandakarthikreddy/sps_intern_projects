package com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.Interface

import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.DataClass.WallpaperItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperService {
    @GET("api/")
    suspend fun getWallpapers(@Query("key") apiKey: String = "47626086-cb873d7b992d88489e8f9d0ad",
                              @Query("q") query: String = "wallpapers",
                              @Query("image_type") imageType: String = "photo"): Response<List<WallpaperItem>>
}

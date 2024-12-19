package com.singlepointsol.wallpaperretrofit.Interface

import com.singlepointsol.wallpaperretrofit.DataClass.WallpaperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperService {
    @GET("api/")
    suspend fun getWallpapers(
        @Query("key") apiKey: String,  // Pass API key as a query parameter
        @Query("q") query: String = "car",  // Optional query parameter
        @Query("image_type") imageType: String = "photo",  // Optional query parameter
        @Query("pretty") pretty: Boolean = true  // Optional query parameter
    ): Response<WallpaperResponse>  // Now returning WallpaperResponse instead of List<WallpaperItem>
}

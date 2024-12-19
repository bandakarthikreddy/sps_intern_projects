package com.singlepointsol.retrofitinstance.Interface

import com.singlepointsol.retrofitinstance.DataClass.AlbumItem
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums(): Response<List<AlbumItem>>
}

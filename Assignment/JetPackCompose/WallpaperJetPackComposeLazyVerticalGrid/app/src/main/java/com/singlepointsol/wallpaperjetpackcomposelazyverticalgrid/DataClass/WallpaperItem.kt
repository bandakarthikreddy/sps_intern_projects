package com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.DataClass

import com.google.gson.annotations.SerializedName

data class WallpaperItem(
    @SerializedName("user")
    val user: String,
    @SerializedName("previewURL")
    val previewURL: String,
    @SerializedName("webformatURL")
    val webFormatURL: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("collections")
    val collections: Int,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("comments")
    val comments: Int
)

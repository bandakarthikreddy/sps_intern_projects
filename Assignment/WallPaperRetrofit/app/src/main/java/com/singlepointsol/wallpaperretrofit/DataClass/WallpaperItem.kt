package com.singlepointsol.wallpaperretrofit.DataClass

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class WallpaperItem(
    @SerializedName("user")
    val user: String,
    @SerializedName("previewURL")
    val previewURL: String,
    @SerializedName("webFormatURL")
    val webFormatURL: String,
    @SerializedName("views")
    val views: String,
    @SerializedName("downloads")
    val downloads: String,
    @SerializedName("collections")
    val collections: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("comments")
    val comments: String
)

data class WallpaperResponse(
    @SerializedName("hits")
    val hits: List<WallpaperItem>  // The actual list of wallpapers
)

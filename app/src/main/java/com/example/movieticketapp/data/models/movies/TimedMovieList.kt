package com.example.movieticketapp.data.models.movies

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TimedMovieList(
    @field:SerializedName("dates") val dates: Dates? = null,
) : BaseMovieList(), Parcelable

@Parcelize
data class Dates(
    @field:SerializedName("maximum")
    val maximum: String? = null,
    @field:SerializedName("minimum")
    val minimum: String? = null,
) : Parcelable

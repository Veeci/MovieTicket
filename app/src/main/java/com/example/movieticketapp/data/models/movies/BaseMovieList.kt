package com.example.movieticketapp.data.models.movies

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
open class BaseMovieList(
    @field:SerializedName("page") open val page: Int? = null,
    @field:SerializedName("results") open val results: List<Result>? = null,
    @field:SerializedName("total_pages") open val totalPages: Int? = null,
    @field:SerializedName("total_results") open val totalResults: Int? = null,
) : Parcelable

@Parcelize
data class Result(
    @field:SerializedName("adult") val adult: Boolean,
    @field:SerializedName("backdrop_path") val backdropPath: String?,
    @field:SerializedName("genre_ids") val genreIds: List<Int>,
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("original_language") val originalLanguage: String,
    @field:SerializedName("original_title") val originalTitle: String,
    @field:SerializedName("overview") val overview: String,
    @field:SerializedName("popularity") val popularity: Double,
    @field:SerializedName("poster_path") val posterPath: String?,
    @field:SerializedName("release_date") val releaseDate: String,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("video") val video: Boolean,
    @field:SerializedName("vote_average") val voteAverage: Double,
    @field:SerializedName("vote_count") val voteCount: Int,
) : Parcelable

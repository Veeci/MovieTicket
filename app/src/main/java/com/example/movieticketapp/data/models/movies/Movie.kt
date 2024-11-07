package com.example.movieticketapp.data.models.movies

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Movie(
    @field:SerializedName("adult") val adult: Boolean,
    @field:SerializedName("backdrop_path") val backdropPath: String,
    @field:SerializedName("belongs_to_collection") val belongsToCollection: BelongsToCollection,
    @field:SerializedName("budget") val budget: Long,
    @field:SerializedName("genres") val genres: List<Genre>,
    @field:SerializedName("homepage") val homepage: String,
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("imdb_id") val imdbId: String,
    @field:SerializedName("origin_country") val originCountry: List<String>,
    @field:SerializedName("original_language") val originalLanguage: String,
    @field:SerializedName("original_title") val originalTitle: String,
    @field:SerializedName("overview") val overview: String,
    @field:SerializedName("popularity") val popularity: Double,
    @field:SerializedName("poster_path") val posterPath: String,
    @field:SerializedName("production_companies") val productionCompanies: List<ProductionCompany>,
    @field:SerializedName("production_countries") val productionCountries: List<ProductionCountry>,
    @field:SerializedName("release_date") val releaseDate: String,
    @field:SerializedName("revenue") val revenue: Long,
    @field:SerializedName("runtime") val runtime: Long,
    @field:SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguage>,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("tagline") val tagline: String,
    @field:SerializedName("title") val title: String,
    @field:SerializedName("video") val video: Boolean,
    @field:SerializedName("vote_average") val voteAverage: Double,
    @field:SerializedName("vote_count") val voteCount: Long,
) : Parcelable

@Parcelize
data class BelongsToCollection(
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("poster_path") val posterPath: String,
    @field:SerializedName("backdrop_path") val backdropPath: String,
) : Parcelable

@Parcelize
data class Genre(
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String,
) : Parcelable

@Parcelize
data class ProductionCompany(
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("logo_path") val logoPath: String?,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("origin_country") val originCountry: String,
) : Parcelable

@Parcelize
data class ProductionCountry(
    @field:SerializedName("iso_3166_1") val iso31661: String,
    @field:SerializedName("name") val name: String,
) : Parcelable

@Parcelize
data class SpokenLanguage(
    @field:SerializedName("english_name") val englishName: String,
    @field:SerializedName("iso_639_1") val iso6391: String,
    @field:SerializedName("name") val name: String,
) : Parcelable

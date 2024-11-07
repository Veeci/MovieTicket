package com.example.movieticketapp.data.service

import com.example.movieticketapp.data.models.BaseResponse
import com.example.movieticketapp.data.models.movies.BaseMovieList
import com.example.movieticketapp.data.models.movies.Movie
import com.example.movieticketapp.data.models.movies.TimedMovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/now_playing")
    suspend fun getNowPLayingMovies(
        @Query("page") page: Int,
    ): BaseResponse<ArrayList<TimedMovieList>>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
    ): BaseResponse<ArrayList<BaseMovieList>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int,
    ): BaseResponse<ArrayList<BaseMovieList>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
    ): BaseResponse<ArrayList<TimedMovieList>>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movie_id: String,
    ): BaseResponse<Movie>
}

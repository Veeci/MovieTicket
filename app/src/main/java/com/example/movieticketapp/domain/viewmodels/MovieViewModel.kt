package com.example.movieticketapp.domain.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieticketapp.data.ApiService
import com.example.movieticketapp.data.models.movies.BaseMovieList
import com.example.movieticketapp.data.models.movies.Movie
import com.example.movieticketapp.data.models.movies.TimedMovieList
import com.koai.base.main.viewmodel.BaseViewModel
import com.koai.base.network.ResponseStatus
import com.koai.base.utils.LogUtils

class MovieViewModel(private val apiService: ApiService) : BaseViewModel() {
    private var currentNowPlayingPage = 1
    var canLoadMoreNowPlaying = true

    private var currentPopularPage = 1
    var canLoadMorePopular = true

    private var currentTopRatedPage = 1
    var canLoadMoreTopRated = true

    private var currentUpcomingPage = 1
    var canLoadMoreUpComing = true

    private val _statusGetNowPLaying = MutableLiveData<ResponseStatus<Boolean>>()
    val statusGetNowPLaying: LiveData<ResponseStatus<Boolean>> = _statusGetNowPLaying

    private val _nowPlayingList = MutableLiveData<ArrayList<TimedMovieList>>()
    val nowPlayingList: LiveData<ArrayList<TimedMovieList>> = _nowPlayingList

    private val _statusGetPopular = MutableLiveData<ResponseStatus<Boolean>>()
    val statusGetPopular: LiveData<ResponseStatus<Boolean>> = _statusGetPopular

    private val _popularList = MutableLiveData<ArrayList<BaseMovieList>>()
    val popularList: LiveData<ArrayList<BaseMovieList>> = _popularList

    private val _statusGetTopRated = MutableLiveData<ResponseStatus<Boolean>>()
    val statusGetTopRated: LiveData<ResponseStatus<Boolean>> = _statusGetTopRated

    private val _topRatedList = MutableLiveData<ArrayList<BaseMovieList>>()
    val topRatedList: LiveData<ArrayList<BaseMovieList>> = _topRatedList

    private val _statusGetUpComing = MutableLiveData<ResponseStatus<Boolean>>()
    val statusGetUpComing: LiveData<ResponseStatus<Boolean>> = _statusGetUpComing

    private val _upComingList = MutableLiveData<ArrayList<TimedMovieList>>()
    val upComingList: LiveData<ArrayList<TimedMovieList>> = _upComingList

    private val _statusGetMovie = MutableLiveData<ResponseStatus<Boolean>>()
    val status: LiveData<ResponseStatus<Boolean>> = _statusGetMovie

    private val _movieDetail = MutableLiveData<Movie?>()
    val movieDetail: LiveData<Movie?> = _movieDetail

    fun getNowPlayingList(isReset: Boolean = false) {
        val currentData =
            if (isReset) {
                currentNowPlayingPage = 1
                canLoadMoreNowPlaying = true
                arrayListOf()
            } else {
                _nowPlayingList.value ?: arrayListOf()
            }
        launchCoroutine {
            _statusGetNowPLaying.postValue(ResponseStatus.Loading)
            val response = apiService.getNowPLayingMovies(currentNowPlayingPage)
            if (response.isSuccess()) {
                if (!response.data.isNullOrEmpty()) {
                    currentData.addAll(response.data)
                    response.data.firstOrNull()?.totalPages?.let {
                        canLoadMoreNowPlaying = (currentNowPlayingPage < it)
                    }
                    if (canLoadMoreNowPlaying) {
                        currentNowPlayingPage++
                    }
                } else {
                    canLoadMoreNowPlaying = false
                }
                LogUtils.log(
                    "MovieVM",
                    "onSuccess: canLoadMoreNowPlaying = $canLoadMoreNowPlaying, currentNowPlayingPage = $currentNowPlayingPage",
                )
                _nowPlayingList.postValue(currentData)
                _statusGetNowPLaying.postValue(ResponseStatus.Success(true))
            } else {
                _statusGetNowPLaying.postValue(
                    ResponseStatus.Error(
                        message = response.message ?: "Unknown error!",
                        errorCode = response.errorCode ?: 500,
                    ),
                )
                _nowPlayingList.postValue(currentData)
            }
        }
    }

    fun getPopularList(isReset: Boolean = false) {
        val currentData =
            if (isReset) {
                currentPopularPage = 1
                canLoadMorePopular = true
                arrayListOf()
            } else {
                _popularList.value ?: arrayListOf()
            }
        launchCoroutine {
            _statusGetPopular.postValue(ResponseStatus.Loading)
            val response = apiService.getPopularMovies(currentPopularPage)
            if (response.isSuccess()) {
                if (!response.data.isNullOrEmpty()) {
                    currentData.addAll(response.data)
                    response.data.firstOrNull()?.totalPages?.let {
                        canLoadMorePopular = (currentPopularPage < it)
                    }
                    if (canLoadMorePopular) {
                        currentPopularPage++
                    }
                } else {
                    canLoadMorePopular = false
                }

                LogUtils.log(
                    "MovieVM:",
                    "onSuccess: canLoadMorePopular: $canLoadMorePopular, currentPopularPage: $currentPopularPage",
                )
                _popularList.postValue(currentData)
                _statusGetPopular.postValue(ResponseStatus.Success(true))
            } else {
                _statusGetPopular.postValue(
                    ResponseStatus.Error(
                        message = response.message ?: "Unknown Error!",
                        errorCode = response.errorCode ?: 500,
                    ),
                )
                _popularList.postValue(currentData)
            }
        }
    }

    fun getTopRatedList(isReset: Boolean = false) {
        val currentData =
            if (isReset) {
                currentTopRatedPage = 1
                canLoadMoreTopRated = true
                arrayListOf()
            } else {
                _topRatedList.value ?: arrayListOf()
            }
        launchCoroutine {
            _statusGetTopRated.postValue(ResponseStatus.Loading)
            val response = apiService.getTopRatedMovies(currentTopRatedPage)
            if (response.isSuccess()) {
                if (!response.data.isNullOrEmpty()) {
                    currentData.addAll(response.data)
                    response.data.firstOrNull()?.totalPages?.let {
                        canLoadMoreTopRated = (currentTopRatedPage < it)
                    }
                    if (canLoadMoreTopRated) {
                        currentTopRatedPage++
                    }
                } else {
                    canLoadMoreTopRated = false
                }
                LogUtils.log(
                    "MovieVM",
                    "onSuccess: canLoadMoreTopRated: $canLoadMoreTopRated, currentTopRatedPage: $currentTopRatedPage",
                )
                _topRatedList.postValue(currentData)
                _statusGetTopRated.postValue(ResponseStatus.Success(true))
            } else {
                _statusGetTopRated.postValue(
                    ResponseStatus.Error(
                        message = response.message ?: "Unknown Error!",
                        errorCode = response.errorCode ?: 500,
                    ),
                )
                _topRatedList.postValue(currentData)
            }
        }
    }

    fun getUpComingList(isReset: Boolean = false) {
        val currentData =
            if (isReset) {
                currentUpcomingPage = 1
                canLoadMoreUpComing = true
                arrayListOf()
            } else {
                _upComingList.value ?: arrayListOf()
            }
        launchCoroutine {
            _statusGetUpComing.postValue(ResponseStatus.Loading)
            val response = apiService.getUpcomingMovies(currentUpcomingPage)
            if (response.isSuccess()) {
                if (!response.data.isNullOrEmpty()) {
                    currentData.addAll(response.data)
                    response.data.firstOrNull()?.totalPages?.let {
                        canLoadMoreUpComing = (currentUpcomingPage < it)
                    }
                    if (canLoadMoreUpComing) {
                        currentUpcomingPage++
                    }
                } else {
                    canLoadMoreUpComing = false
                }
                LogUtils.log(
                    "MovieVM",
                    "onSuccess: canLoadMoreUpComing: $canLoadMoreUpComing, currentUpComingPage = $currentUpcomingPage",
                )
                _upComingList.postValue(currentData)
                _statusGetUpComing.postValue(ResponseStatus.Success(true))
            } else {
                _statusGetUpComing.postValue(
                    ResponseStatus.Error(
                        message = response.message ?: "Unknown Error!",
                        errorCode = response.errorCode ?: 500,
                    ),
                )
                _upComingList.postValue(currentData)
            }
        }
    }

    fun getMovieDetail(movieId: String) {
        _statusGetMovie.postValue(ResponseStatus.Loading)
        launchCoroutine {
            val response = apiService.getMovie(movieId)
            if (response.isSuccess()) {
                LogUtils.log(
                    "MovieVM:",
                    "onSuccess: movieId: ${response.data?.id}",
                )
                _movieDetail.postValue(response.data)
                _statusGetMovie.postValue(ResponseStatus.Success(true))
            }
        }
    }
}

package com.mindorks.framework.mvvm.data.api


import MovieApiInterface
import com.abhishek.dummyapp.data.Movies
import retrofit2.Call
import retrofit2.Response

class ApiHelperImpl(private val apiInterface: MovieApiInterface) : ApiHelper {

    override suspend fun getPopularMovies(): Call<Movies> = apiInterface.getPopularMovies("566acfac3490ea46c8e4cd03a416a567")

}
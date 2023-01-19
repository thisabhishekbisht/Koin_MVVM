package com.mindorks.framework.mvvm.data.api

import com.abhishek.dummyapp.data.Movies
import retrofit2.Call
import retrofit2.Response

interface ApiHelper {

    suspend fun  getPopularMovies(): Call<Movies>

}
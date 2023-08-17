package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    fun moviesApi(): MoviesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.movieUrl)
            //add a client allows us to intercept the network traffic
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }

    fun samEmailerApi(): SamEmailerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.samEmailerUrl)
            //add a client allows us to intercept the network traffic
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SamEmailerApi::class.java)
    }

    fun favoriteMoviesApi(): FavoriteMoviesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.favoriteMovieUrl)
            //add a client allows us to intercept the network traffic
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoriteMoviesApi::class.java)
    }


    private fun getOkHttpClient() = OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()

    //todo set HttpLoggingInterceptor.Level.BODY to HttpLoggingInterceptor.Level.NONE for production release
    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}
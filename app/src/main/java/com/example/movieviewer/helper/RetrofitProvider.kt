package com.example.movieviewer.helper

import retrofit2.Retrofit

/**
 * Created by Vincent on 11/10/18
 */
object RetrofitProvider {

  private var retrofit: Retrofit? = null

  fun retrofit(): Retrofit {

    if (retrofit == null) {
      //TODO("Initialize Retrofit"
    }
    return retrofit!!
  }
}
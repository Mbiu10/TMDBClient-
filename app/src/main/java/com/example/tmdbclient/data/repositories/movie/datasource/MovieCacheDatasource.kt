package com.example.tmdbclient.data.repositories.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}
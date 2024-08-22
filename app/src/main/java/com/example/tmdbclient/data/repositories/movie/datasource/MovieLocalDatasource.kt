package com.example.tmdbclient.data.repositories.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}
package com.example.tmdbclient.data.repositories.movie.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repositories.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}
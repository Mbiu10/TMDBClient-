package com.example.tmdbclient.data.repositories.tvshow.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}
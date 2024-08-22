package com.example.tmdbclient.data.repositories.tvshow.datasource

import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows():Response<TvShowList>
}
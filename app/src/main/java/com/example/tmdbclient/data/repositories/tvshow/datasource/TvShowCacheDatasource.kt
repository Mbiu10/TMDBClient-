package com.example.tmdbclient.data.repositories.tvshow.datasource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}
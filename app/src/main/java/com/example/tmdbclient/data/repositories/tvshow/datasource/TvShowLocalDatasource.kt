package com.example.tmdbclient.data.repositories.tvshow.datasource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}
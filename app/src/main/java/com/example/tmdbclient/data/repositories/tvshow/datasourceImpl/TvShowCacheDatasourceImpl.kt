package com.example.tmdbclient.data.repositories.tvshow.datasourceImpl

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
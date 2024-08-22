package com.example.tmdbclient.presentation.daggerInjection.core

import com.example.tmdbclient.data.repositories.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclient.data.repositories.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.example.tmdbclient.data.repositories.movie.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repositories.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDatasource
import com.example.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource():MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }
    @Singleton
    @Provides
    fun provideTvShowCacheDatasource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDatasource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

}
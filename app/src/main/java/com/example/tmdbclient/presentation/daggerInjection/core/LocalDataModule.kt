package com.example.tmdbclient.presentation.daggerInjection.core

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclient.data.repositories.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.example.tmdbclient.data.repositories.movie.datasource.MovieLocalDatasource
import com.example.tmdbclient.data.repositories.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao):MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideTvShowLocalDatasource(tvShowDao: TvShowDao):TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }
}
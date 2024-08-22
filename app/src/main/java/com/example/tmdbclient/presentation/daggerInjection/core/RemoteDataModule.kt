package com.example.tmdbclient.presentation.daggerInjection.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclient.data.repositories.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.example.tmdbclient.data.repositories.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repositories.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService,apiKey)
    }
}
package com.example.tmdbclient.presentation.daggerInjection.core

import com.example.tmdbclient.data.repositories.artist.ArtistRepositoryImpl
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclient.data.repositories.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.repositories.movie.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repositories.movie.datasource.MovieLocalDatasource
import com.example.tmdbclient.data.repositories.movie.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repositories.tvshow.TvShowRepositoryImpl
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDatasource
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowLocalDatasource
import com.example.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }
    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }
    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

}
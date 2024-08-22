package com.example.tmdbclient.presentation.daggerInjection.core

import com.example.tmdbclient.presentation.daggerInjection.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.daggerInjection.movie.MovieSubComponent
import com.example.tmdbclient.presentation.daggerInjection.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}
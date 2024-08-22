package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.daggerInjection.Injector
import com.example.tmdbclient.presentation.daggerInjection.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.daggerInjection.core.AppComponent
import com.example.tmdbclient.presentation.daggerInjection.core.AppModule
import com.example.tmdbclient.presentation.daggerInjection.core.DaggerAppComponent
import com.example.tmdbclient.presentation.daggerInjection.core.NetModule
import com.example.tmdbclient.presentation.daggerInjection.core.RemoteDataModule
import com.example.tmdbclient.presentation.daggerInjection.movie.MovieSubComponent
import com.example.tmdbclient.presentation.daggerInjection.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}
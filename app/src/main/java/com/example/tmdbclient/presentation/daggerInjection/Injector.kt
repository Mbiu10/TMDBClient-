package com.example.tmdbclient.presentation.daggerInjection

import com.example.tmdbclient.presentation.daggerInjection.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.daggerInjection.movie.MovieSubComponent
import com.example.tmdbclient.presentation.daggerInjection.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}
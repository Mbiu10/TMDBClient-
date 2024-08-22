package com.example.tmdbclient.data.repositories.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}
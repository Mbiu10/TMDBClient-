package com.example.tmdbclient.data.repositories.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}
package com.example.tmdbclient.data.repositories.artist.datasource

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists():Response<ArtistList>
}
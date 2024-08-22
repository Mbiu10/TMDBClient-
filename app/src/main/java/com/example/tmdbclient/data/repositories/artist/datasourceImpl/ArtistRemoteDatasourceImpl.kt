package com.example.tmdbclient.data.repositories.artist.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}
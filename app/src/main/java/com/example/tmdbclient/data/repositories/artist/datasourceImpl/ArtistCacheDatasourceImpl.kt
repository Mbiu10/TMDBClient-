package com.example.tmdbclient.data.repositories.artist.datasourceImpl

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl: ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
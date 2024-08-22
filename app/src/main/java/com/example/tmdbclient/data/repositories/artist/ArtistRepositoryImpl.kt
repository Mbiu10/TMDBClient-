package com.example.tmdbclient.data.repositories.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistCacheDatasource
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistLocalDatasource
import com.example.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDatasource
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
       val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
           artistList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}
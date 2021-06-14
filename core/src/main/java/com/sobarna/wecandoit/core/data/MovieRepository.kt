package com.sobarna.wecandoit.core.data


import com.sobarna.wecandoit.core.data.source.local.LocalDataSource
import com.sobarna.wecandoit.core.data.source.remote.RemoteDataSource
import com.sobarna.wecandoit.core.data.source.remote.network.ApiResponse
import com.sobarna.wecandoit.core.data.source.remote.response.MovieResponse
import com.sobarna.wecandoit.core.domain.model.Movie
import com.sobarna.wecandoit.core.domain.repository.IMovieRepository
import com.sobarna.wecandoit.core.utils.AppExecutors
import com.sobarna.wecandoit.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
               return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> {
                return  remoteDataSource.getAllMovie()
            }

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }

        }.asFlow()
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {  asd ->
            DataMapper.mapEntitiesToDomain(asd) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(tourismEntity, state) }
    }
}
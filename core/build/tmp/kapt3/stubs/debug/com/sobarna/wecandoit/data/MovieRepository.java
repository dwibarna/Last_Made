package com.sobarna.wecandoit.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/sobarna/wecandoit/data/MovieRepository;", "Lcom/sobarna/wecandoit/domain/repository/IMovieRepository;", "remoteDataSource", "Lcom/sobarna/wecandoit/data/source/remote/RemoteDataSource;", "localDataSource", "Lcom/sobarna/wecandoit/data/source/local/LocalDataSource;", "appExecutors", "Lcom/sobarna/wecandoit/utils/AppExecutors;", "(Lcom/sobarna/wecandoit/data/source/remote/RemoteDataSource;Lcom/sobarna/wecandoit/data/source/local/LocalDataSource;Lcom/sobarna/wecandoit/utils/AppExecutors;)V", "getAllMovies", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sobarna/wecandoit/data/Resource;", "", "Lcom/sobarna/wecandoit/domain/model/Movie;", "getFavoriteMovie", "setFavoriteMovie", "", "movie", "state", "", "core_debug"})
public final class MovieRepository implements com.sobarna.wecandoit.domain.repository.IMovieRepository {
    private final com.sobarna.wecandoit.data.source.remote.RemoteDataSource remoteDataSource = null;
    private final com.sobarna.wecandoit.data.source.local.LocalDataSource localDataSource = null;
    private final com.sobarna.wecandoit.utils.AppExecutors appExecutors = null;
    
    public MovieRepository(@org.jetbrains.annotations.NotNull()
    com.sobarna.wecandoit.data.source.remote.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    com.sobarna.wecandoit.data.source.local.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull()
    com.sobarna.wecandoit.utils.AppExecutors appExecutors) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.sobarna.wecandoit.data.Resource<java.util.List<com.sobarna.wecandoit.domain.model.Movie>>> getAllMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.sobarna.wecandoit.domain.model.Movie>> getFavoriteMovie() {
        return null;
    }
    
    @java.lang.Override()
    public void setFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.sobarna.wecandoit.domain.model.Movie movie, boolean state) {
    }
}
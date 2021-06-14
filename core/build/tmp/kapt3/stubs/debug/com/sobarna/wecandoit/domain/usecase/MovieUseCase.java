package com.sobarna.wecandoit.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/sobarna/wecandoit/domain/usecase/MovieUseCase;", "", "getAllMovie", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sobarna/wecandoit/data/Resource;", "", "Lcom/sobarna/wecandoit/domain/model/Movie;", "getFavoriteMovie", "setFavoriteMovie", "", "movie", "state", "", "core_debug"})
public abstract interface MovieUseCase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.sobarna.wecandoit.data.Resource<java.util.List<com.sobarna.wecandoit.domain.model.Movie>>> getAllMovie();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.sobarna.wecandoit.domain.model.Movie>> getFavoriteMovie();
    
    public abstract void setFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.sobarna.wecandoit.domain.model.Movie movie, boolean state);
}
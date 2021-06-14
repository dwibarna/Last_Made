package com.sobarna.wecandoit.data.source.remote.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0005"}, d2 = {"Lcom/sobarna/wecandoit/data/source/remote/network/ApiService;", "", "getListMovie", "Lcom/sobarna/wecandoit/data/source/remote/response/ListMovieResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "3/movie/upcoming?api_key=338e9f156f9f274bed38580ad4810b0f")
    public abstract java.lang.Object getListMovie(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sobarna.wecandoit.data.source.remote.response.ListMovieResponse> p0);
}
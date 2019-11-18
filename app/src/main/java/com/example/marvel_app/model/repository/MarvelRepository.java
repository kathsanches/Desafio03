package com.example.marvel_app.model.repository;

import com.example.marvel_app.model.pojos.ComicsResult;

import io.reactivex.Observable;

import static com.example.marvel_app.model.data.remote.RetrofitService.getApiService;

public class MarvelRepository {

    public Observable<ComicsResult> getComics(String format, String formatType, boolean noVariants, String orderBy, String limit, String ts, String hash, String apiKey) {
        return getApiService().getAllComics(format, formatType, noVariants,orderBy, limit, ts, hash, apiKey);
    }
}




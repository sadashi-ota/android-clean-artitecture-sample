package com.sadashi.apps.cleanartitecture.externals.infra

import com.sadashi.apps.cleanartitecture.entities.QiitaTag
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaApiService {
    @GET("api/v2/tags")
    fun getTags(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int,
            @Query("sort") sort: String
    ): Single<List<QiitaTag>>
}
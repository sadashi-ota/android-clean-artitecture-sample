package com.sadashi.apps.cleanartitecture.external.infra

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class QiitaRemoteDataSource {

    val apiService = createApiClient()

    private fun createApiClient(): QiitaApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://qiita.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(QiitaApiService::class.java)
    }

    fun getTags(): Single<List<QiitaTag>> {
        return apiService.getTags(1, 20, "count")
    }
}
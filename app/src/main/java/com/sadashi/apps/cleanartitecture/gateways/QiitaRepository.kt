package com.sadashi.apps.cleanartitecture.gateways

import com.sadashi.apps.cleanartitecture.externals.infra.QiitaRemoteDataSource
import com.sadashi.apps.cleanartitecture.entities.QiitaTag
import io.reactivex.Single

class QiitaRepository(
        val remoteDataSource: QiitaRemoteDataSource
) {

    fun getTags(): Single<List<QiitaTag>> {
        return remoteDataSource.getTags()
    }

    companion object {

        private var INSTANCE: QiitaRepository? = null

        @JvmStatic
        fun getInstance(remoteDataSource: QiitaRemoteDataSource): QiitaRepository {
            return INSTANCE ?: QiitaRepository(remoteDataSource).also { INSTANCE = it }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
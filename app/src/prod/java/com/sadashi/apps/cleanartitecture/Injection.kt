package com.sadashi.apps.cleanartitecture

import com.sadashi.apps.cleanartitecture.externals.infra.QiitaRemoteDataSource
import com.sadashi.apps.cleanartitecture.gateways.QiitaRepository

object Injection {
    fun provideQiitaRepository(): QiitaRepository {
        return QiitaRepository.getInstance(QiitaRemoteDataSource())
    }
}
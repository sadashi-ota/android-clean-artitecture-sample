package com.sadashi.apps.cleanartitecture.gateways

import com.sadashi.apps.cleanartitecture.externals.infra.QiitaRemoteDataSource
import com.sadashi.apps.cleanartitecture.extensions.observeOnMainThread
import com.sadashi.apps.cleanartitecture.usecases.QiitaUseCasePort
import io.reactivex.schedulers.Schedulers

class QiitaRepository(
        private val remoteDataSource: QiitaRemoteDataSource
) : QiitaUseCasePort.OutputFromPresenter {

    var useCaseInput: QiitaUseCasePort.InputFromRepository? = null

    override fun doLoadTags(page: Int) {
        remoteDataSource.getTags(page)
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .doOnSuccess {
                    useCaseInput?.didLoadTags(it)
                }
                .doOnError {
                    useCaseInput?.didLoadTagsError(it)
                }
                .subscribe()
    }
}
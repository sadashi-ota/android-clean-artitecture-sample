package com.sadashi.apps.cleanartitecture.presenters

import com.sadashi.apps.cleanartitecture.extensions.observeOnMainThread
import com.sadashi.apps.cleanartitecture.gateways.QiitaRepository
import io.reactivex.schedulers.Schedulers

class MainPresenter(
        private val qiitaRepository: QiitaRepository,
        private val view: MainContract.View
) : MainContract.Presenter {

    override fun start() {
        load()
    }

    override fun load() {
        qiitaRepository.getTags()
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .doOnSuccess { view.showTags(it) }
                .subscribe()

    }
}

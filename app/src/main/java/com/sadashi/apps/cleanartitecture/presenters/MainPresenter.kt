package com.sadashi.apps.cleanartitecture.presenters

import com.sadashi.apps.cleanartitecture.extensions.observeOnMainThread
import com.sadashi.apps.cleanartitecture.gateways.QiitaRepository
import io.reactivex.schedulers.Schedulers

class MainPresenter(
        private val qiitaRepository: QiitaRepository,
        private val view: MainContract.View
) : MainContract.Presenter {

    private var loadedPage = 0
    private var isLoading = false

    override fun start() {
        loadedPage = 0
        view.clearTags()
        loadNextTags()
    }

    override fun loadNextTags() {
        isLoading = true
        qiitaRepository.getTags(loadedPage + 1)
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .doOnSuccess {
                    loadedPage++
                    isLoading = false
                    view.showTags(it)
                }
                .doOnError {
                    isLoading = false
                    view.showError(it)
                }
                .subscribe()

    }
}

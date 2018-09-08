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
        forceRefresh()
    }

    override fun loadNextTags() {
        if (isLoading) {
            return
        }

        isLoading = true
        qiitaRepository.getTags(loadedPage + 1)
                .subscribeOn(Schedulers.io())
                .observeOnMainThread()
                .doOnSuccess {
                    loadedPage++
                    isLoading = false
                    view.showTags(it)
                    view.showLoading(false)
                }
                .doOnError {
                    isLoading = false
                    view.showError(it)
                    view.showLoading(false)
                }
                .subscribe()

    }

    override fun forceRefresh() {
        loadedPage = 0
        view.showLoading(true)
        view.clearTags()
        loadNextTags()
    }
}

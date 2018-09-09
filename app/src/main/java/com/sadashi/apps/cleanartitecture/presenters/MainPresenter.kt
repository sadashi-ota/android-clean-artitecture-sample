package com.sadashi.apps.cleanartitecture.presenters

import com.sadashi.apps.cleanartitecture.entities.QiitaTag
import com.sadashi.apps.cleanartitecture.usecases.QiitaUseCasePort

class MainPresenter(
        private val view: MainContract.View
) : MainContract.Presenter, QiitaUseCasePort.OutputFromRepository {

    var useCaseInput: QiitaUseCasePort.InputFromPresenter? = null

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
        useCaseInput?.doLoadTags(loadedPage + 1)
    }

    override fun forceRefresh() {
        loadedPage = 0
        view.showLoading(true)
        view.clearTags()
        loadNextTags()
    }

    override fun didLoadTags(tags: List<QiitaTag>) {
        isLoading = false
        view.showLoading(false)

        view.showTags(tags)
        loadedPage++
    }

    override fun didLoadTagsError(t: Throwable) {
        view.showLoading(false)
        isLoading = false
        view.showError(t)
    }

}

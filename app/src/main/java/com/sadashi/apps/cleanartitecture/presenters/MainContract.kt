package com.sadashi.apps.cleanartitecture.presenters

import com.sadashi.apps.cleanartitecture.entities.QiitaTag

interface MainContract {
    interface View {
        var presenter: Presenter
        fun clearTags()
        fun showTags(tags: List<QiitaTag>)
        fun showError(t: Throwable)
    }

    interface Presenter {
        fun start()
        fun loadNextTags()
    }
}
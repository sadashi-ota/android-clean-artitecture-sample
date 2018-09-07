package com.sadashi.apps.cleanartitecture.presenters

import com.sadashi.apps.cleanartitecture.entities.QiitaTag

interface MainContract {
    interface View {
        var presenter: Presenter
        fun showTags(tags: List<QiitaTag>)
    }

    interface Presenter {
        fun start()
        fun load()
    }
}
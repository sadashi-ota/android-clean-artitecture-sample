package com.sadashi.apps.cleanartitecture.presenter

interface MainContract {
    interface View {
        var presenter: Presenter
        fun showTags()
    }

    interface Presenter {
        fun start()
        fun load()
    }
}
package com.sadashi.apps.cleanartitecture.external.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sadashi.apps.cleanartitecture.R
import com.sadashi.apps.cleanartitecture.presenter.MainContract

class MainFragment : Fragment(), MainContract.View {
    override var presenter: MainContract.Presenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun showTags() {
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

}

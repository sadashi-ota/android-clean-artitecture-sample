package com.sadashi.apps.cleanartitecture.externals.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sadashi.apps.cleanartitecture.R
import com.sadashi.apps.cleanartitecture.entities.QiitaTag
import com.sadashi.apps.cleanartitecture.externals.view.adapters.QiitaTagAdapter
import com.sadashi.apps.cleanartitecture.presenters.MainContract
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), MainContract.View {
    override lateinit var presenter: MainContract.Presenter

    override fun showTags(tags: List<QiitaTag>) {
        list_view.adapter = QiitaTagAdapter().also {
            it.tags.clear()
            it.tags.addAll(tags)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }
}

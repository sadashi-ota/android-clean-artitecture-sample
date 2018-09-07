package com.sadashi.apps.cleanartitecture.externals.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sadashi.apps.cleanartitecture.Injection
import com.sadashi.apps.cleanartitecture.R
import com.sadashi.apps.cleanartitecture.presenters.MainPresenter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            val fragment = MainFragment.newInstance()
            fragment.presenter = MainPresenter(Injection.provideQiitaRepository(), fragment)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow()
        }
    }

}

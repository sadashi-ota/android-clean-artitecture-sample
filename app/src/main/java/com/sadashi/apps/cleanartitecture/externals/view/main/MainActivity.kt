package com.sadashi.apps.cleanartitecture.externals.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sadashi.apps.cleanartitecture.Injection
import com.sadashi.apps.cleanartitecture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            val fragment = MainFragment.newInstance()
            fragment.presenter = Injection.provideMainPresenter(fragment)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow()
        }
    }

}

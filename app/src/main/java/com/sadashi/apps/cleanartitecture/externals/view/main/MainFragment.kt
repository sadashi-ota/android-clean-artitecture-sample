package com.sadashi.apps.cleanartitecture.externals.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sadashi.apps.cleanartitecture.R
import com.sadashi.apps.cleanartitecture.entities.QiitaTag
import com.sadashi.apps.cleanartitecture.externals.view.adapters.QiitaTagAdapter
import com.sadashi.apps.cleanartitecture.presenters.MainContract
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    companion object {
        private const val RequestPreLoadNum = 4
        fun newInstance() = MainFragment()
    }

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
            val lastVisibleItemCount = layoutManager!!.findLastVisibleItemPosition() + 1
            val totalItemCount = layoutManager.itemCount

            if (totalItemCount <= lastVisibleItemCount + RequestPreLoadNum) {
                presenter.loadNextTags()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh_layout.setOnRefreshListener {
            presenter.forceRefresh()
        }
        list_view.adapter = QiitaTagAdapter()
        list_view.addOnScrollListener(scrollListener)
    }

    override fun onResume() {
        super.onResume()
        if (!::presenter.isInitialized) {
            throw RuntimeException("Presenter is null.")
        }
        presenter.start()
    }

    override fun clearTags() {
        val adapter = list_view.adapter as QiitaTagAdapter
        adapter.tags.clear()
        adapter.notifyDataSetChanged()
    }

    override fun showTags(tags: List<QiitaTag>) {
        val adapter = list_view.adapter as QiitaTagAdapter
        adapter.tags.addAll(tags)
        adapter.notifyItemRangeChanged(adapter.tags.size - tags.size, tags.size)
    }

    override fun showError(t: Throwable) {
        Toast.makeText(context, R.string.message_load_error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean) {
        refresh_layout.isRefreshing = show
    }
}

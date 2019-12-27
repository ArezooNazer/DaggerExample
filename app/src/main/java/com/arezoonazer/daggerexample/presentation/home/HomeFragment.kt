package com.arezoonazer.daggerexample.presentation.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import android.widget.LinearLayout.VISIBLE
import android.widget.ProgressBar
import com.arezoonazer.daggerexample.R
import com.arezoonazer.daggerexample.data.repository.HomeRepository

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
    private lateinit var viewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var progressbar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment onCreate")
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout(view)
        getHomeData()

        viewModel.homeList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "home list observer: $it")
            it?.let { items ->
                adapter.swapData(items)
                progressbar.visibility = View.GONE
            }
        })
    }

    private fun initData() {
        val factory = HomeViewModelFactory(HomeRepository.getHomeReposInstance())
        viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        adapter = HomeAdapter()
    }

    private fun getHomeData() {
        viewModel.getHomeList()
        progressbar.visibility = View.VISIBLE
    }

    private fun setupLayout(view: View) {
        recyclerView = view.findViewById(R.id.home_rv)
        recyclerView.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        recyclerView.adapter = adapter
        progressbar = view.findViewById(R.id.progress_bar)
    }
}
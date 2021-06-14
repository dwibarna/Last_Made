package com.sobarna.wecandoit.dynamicfeature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sobarna.wecandoit.core.adapter.MovieAdapter
import com.sobarna.wecandoit.dynamicfeature.databinding.ActivityDynamicFeatureBinding
import com.sobarna.wecandoit.dynamicfeature.module.dynamicModule
import com.sobarna.wecandoit.view.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class DynamicFeatureActivity : AppCompatActivity() {

    private val viewModel: DynamicFeatureViewModel by viewModel()
    private lateinit var binding: ActivityDynamicFeatureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicFeatureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(dynamicModule)

        getFavoriteData()
    }

    private fun getFavoriteData() {
        val movieAdapter = MovieAdapter()

        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
        viewModel.useCase.observe(this, { movie ->
            movieAdapter.setData(movie)
        })

        with(binding.rvDynamic) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}
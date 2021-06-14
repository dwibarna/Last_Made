package com.sobarna.wecandoit.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sobarna.wecandoit.R
import com.sobarna.wecandoit.databinding.ActivityDetailBinding
import com.sobarna.wecandoit.core.domain.model.Movie
import com.sobarna.wecandoit.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetail(detailMovie)
    }

    @SuppressLint("SimpleDateFormat")
    private fun showDetail(movie: Movie?) {
        movie?.let {

            val oldDate = movie.release_date
            val yearFormat: DateFormat = SimpleDateFormat("yyyy")
            val newFormat: DateFormat = SimpleDateFormat("dd MMMM yyyy")
            val df = SimpleDateFormat("yyyy-MM-dd")
            val yearDate = yearFormat.format(df.parse(oldDate)!!)
            val currentDate = newFormat.format(df.parse(oldDate)!!)

            val title :String = movie.title+" ($yearDate)"
            val dateRelease :String = currentDate +" (${movie.original_language.uppercase()})"
            val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
            val userScore:String = (movie.vote_average.toInt()*10).toString() +'%'
            val overview = "\t ${movie.overview}"

            Glide.with(this)
                .load(imageUrl)
                .into(binding.ivAvatarDetail)

            binding.tvTitleDetail.text = title
            binding.tvDateDetail.text = dateRelease

            binding.tvUserScoreDetail.text = userScore
            binding.tvOverViewDetail.text = overview

            var statusFavorite = movie.favorite
            setStatusFavorite(statusFavorite)
            binding.fabDetail.setOnClickListener {
               statusFavorite = !statusFavorite
                viewModel.setFavoriteMovie(movie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabDetail.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.ic_favorite_white
            ))
        } else {
            binding.fabDetail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}





package com.abhishek.dummyapp

import MovieViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.abhishek.dummyapp.adapter.MovieAdapter
import com.abhishek.dummyapp.databinding.ActivityMainBinding
import com.abhishek.dummyapp.utils.Status

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   // private lateinit var viewModel: MovieViewModel
    private val viewModel : MovieViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
   //     viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        // onCreate
  /*      viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)).get(MovieViewModel::class.java)*/
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer {
            /*observe here */
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE

                    it.data?.let { movies ->  movieAdapter.setMovieList(movies) }

                    binding.rvMovies.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvMovies.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }

        })
    }



    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = movieAdapter
        }
    }
}








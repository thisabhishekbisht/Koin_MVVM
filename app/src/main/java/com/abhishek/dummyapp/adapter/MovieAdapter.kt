package com.abhishek.dummyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.dummyapp.databinding.MovieLayoutBinding
import com.bumptech.glide.Glide

class MovieAdapter  : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList = ArrayList<com.abhishek.dummyapp.data.Result>()
    fun setMovieList(movieList: List<com.abhishek.dummyapp.data.Result>) {
        this.movieList = movieList as ArrayList<com.abhishek.dummyapp.data.Result>
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }



    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].title
    }


    class ViewHolder(val binding : MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {

    }


}
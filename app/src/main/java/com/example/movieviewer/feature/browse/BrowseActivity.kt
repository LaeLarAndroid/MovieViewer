package com.example.movieviewer.feature.browse

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.movieviewer.R.layout
import com.example.movieviewer.model.Movie
import kotlinx.android.synthetic.main.activity_browse.progressBar
import kotlinx.android.synthetic.main.activity_browse.rvMovie
import kotlinx.android.synthetic.main.activity_browse.viewRoot

class BrowseActivity : AppCompatActivity() {

  private val movieRecyclerViewAdapter = MovieRecyclerViewAdapter()

  //TODO("Initialize retrofit")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_browse)
    title = "Popular"

    //Link recycler view to adapter
    rvMovie.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    rvMovie.adapter = movieRecyclerViewAdapter

  }

  fun getMovieList() {
    TODO("Get Movie List from API")
  }

  fun showLoading() {
    progressBar.visibility = View.VISIBLE
    rvMovie.visibility = View.GONE
  }

  fun showMovieList(movieList: List<Movie>) {
    progressBar.visibility = View.GONE
    rvMovie.visibility = View.VISIBLE
    movieRecyclerViewAdapter.submitList(movieList)
  }

  fun showError() {
    progressBar.visibility = View.GONE
    rvMovie.visibility = View.GONE

    Snackbar.make(viewRoot, "Error loading data", Snackbar.LENGTH_INDEFINITE)
      .setAction("Retry") {
        getMovieList()
      }
      .show()
  }

}

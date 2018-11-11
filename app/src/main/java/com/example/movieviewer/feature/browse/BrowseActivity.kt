package com.example.movieviewer.feature.browse

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.movieviewer.R
import com.example.movieviewer.model.Movie
import kotlinx.android.synthetic.main.activity_browse.progressBar
import kotlinx.android.synthetic.main.activity_browse.rvMovie
import kotlinx.android.synthetic.main.activity_browse.viewRoot

class BrowseActivity : AppCompatActivity() {

  private val movieRecyclerViewAdapter = MovieRecyclerViewAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_browse)
    title = "Popular"

    //Link recycler view to adapter
    rvMovie.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    rvMovie.adapter = movieRecyclerViewAdapter

    loadData()
  }

  private fun loadData() {
    TODO("Get Movie List from API")
  }

  private fun showLoading() {
    progressBar.visibility = View.VISIBLE
    rvMovie.visibility = View.GONE
  }

  private fun showMovieList(movieList: List<Movie>) {
    progressBar.visibility = View.GONE
    rvMovie.visibility = View.VISIBLE
    movieRecyclerViewAdapter.submitList(movieList)
  }

  private fun showError() {
    progressBar.visibility = View.GONE
    rvMovie.visibility = View.GONE

    val snackBar = Snackbar.make(viewRoot, "Error loading data", Snackbar.LENGTH_INDEFINITE)

    snackBar.setAction("Retry") {
      loadData()
      snackBar.dismiss()
    }

    snackBar.show()
  }

}

package com.example.tmdbclient.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.presentation.daggerInjection.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)
       initRecyclerView()





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it!=null){
             adapter.setList(it)
             adapter.notifyDataSetChanged()
             binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}
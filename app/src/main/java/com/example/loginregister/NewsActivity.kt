package com.example.loginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginregister.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private lateinit var adapter: NewsAdapter
    private val viewModel by viewModels<NewsViewModel>()
    val list = ArrayList<ArticlesItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.setHasFixedSize(true)
        adapter = NewsAdapter(list)

        binding.apply {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    searchView.hide()
                    searchUser()
                    false
                }
            searchUser()
        }
        viewModel.getSearchUser().observe(this){
            adapter.setlistNews(it)
        }
    }

    private fun searchUser() {
        binding.apply {
            var query = searchView.text.toString()
            if (query.isEmpty()) {
                query = "military"
            }
            viewModel.getNews(query, binding.rvNews, adapter)
        }
    }
}
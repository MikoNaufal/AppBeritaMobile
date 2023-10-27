package com.example.loginregister

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    val news = MutableLiveData<ArrayList<ArticlesItem>>()

    fun getNews(
        topic: String,
        rv: RecyclerView,
        adapter: NewsAdapter
    ) {
        RetrofitClient.apiInstance.getSearchNews(topic)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        val newsList = response.body()?.articles ?: emptyList()
                        news.postValue(newsList as ArrayList<ArticlesItem>?)
                        rv.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.d("Connection Error", t.message.toString())
                }

            })
    }

    fun getSearchUser(): LiveData<ArrayList<ArticlesItem>> {
        return news
    }
}
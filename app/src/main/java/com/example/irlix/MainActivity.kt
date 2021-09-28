package com.example.irlix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.irlix.database.NewsDao
import com.example.irlix.database.NewsDatabase
import com.example.irlix.database.NewsEntity
import com.example.irlix.network.DataNews
import com.example.irlix.network.NewsInterface
import com.example.irlix.network.NewsService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = NewsService.buildService(NewsInterface::class.java)
        val call = request.getNews("apple", "ru", "RU", "RU:ru")

        call.enqueue(
            object : Callback<DataNews> {
                override fun onResponse(call: Call<DataNews>, response: Response<DataNews>) {
                    if (response.isSuccessful) {
                        val pb = findViewById<ProgressBar>(R.id.progress_bar)
                        val rv = findViewById<RecyclerView>(R.id.recyclerView)

                        Log.e("1st is ", response.body()!!.results.toString())

                        pb.visibility = View.GONE
                        rv.apply {
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = NewsAdapter(response.body()!!.results)


                            Log.e("NEWS is ", response.body()!!.results.toString())
//                            val news = NewsDatabase.getNewsDB(this@MainActivity)
//                            news.newsDao().getAll()
                        }
                    }
                }

                override fun onFailure(call: Call<DataNews>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "pza", Toast.LENGTH_SHORT).show()
                    Log.e("fail", "fail")
                }
            })

        /*
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            NewsService.buildService().getNews("dpawok")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t)})
        )
        */
    }
/*
    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: DataNews) {
        val pb = findViewById<ProgressBar>(R.id.progress_bar)
        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        pb.visibility = View.GONE
        rv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = NewsAdapter(response.results)
        }
    }
     */
}
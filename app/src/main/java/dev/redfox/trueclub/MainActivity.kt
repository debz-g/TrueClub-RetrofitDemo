package dev.redfox.trueclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.redfox.trueclub.data.MainViewModel
import dev.redfox.trueclub.data.MainViewModelFactory
import dev.redfox.trueclub.databinding.ActivityMainBinding
import dev.redfox.trueclub.models.Country
import dev.redfox.trueclub.networking.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var dataAdapter: DataAdapter

    private val repository: Repository by lazy {
        Repository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        binding.btnSearch.setOnClickListener {
            if (!binding.searchEditText.text!!.isEmpty()){

                mainViewModel.getDetails(binding.searchEditText.text.toString())

                mainViewModel.response.observe(this, {

                    val nData : MutableList<Country> = it.body()?.country as MutableList<Country>
                    dataAdapter = DataAdapter(this, nData)

                    val adapter = dataAdapter

                    binding.searchRecyclerView.setHasFixedSize(true)
                    binding.searchRecyclerView.adapter = adapter
                    binding.searchRecyclerView.layoutManager = LinearLayoutManager(this)
                })
            }
        }
    }
}
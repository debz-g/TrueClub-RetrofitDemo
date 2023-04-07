package dev.redfox.trueclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.redfox.trueclub.data.MainViewModel
import dev.redfox.trueclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
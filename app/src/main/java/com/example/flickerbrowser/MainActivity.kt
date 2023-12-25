package com.example.flickerbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.flickerbrowser.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            lifecycleScope.launch(Dispatchers.IO) {
                val response = try {
                    Api.api.getImages("json", "1")
                } catch (e: HttpException) {
                    Log.d(TAG, "HttpException: Unexpected request")
                    return@launch
                } catch (e: IOException) {
                    Log.d(TAG, "IOException: $e")
                    return@launch
                }

                if (response.isSuccessful && response.body() != null)
                    Log.d(TAG, "Response: $response")
            }
        }
    }
}
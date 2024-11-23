package com.example.mvvmcleanarchitectureflavors.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitectureflavors.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.example.mvvmcleanarchitectureflavors.R
import com.example.mvvmcleanarchitectureflavors.presentation.adapter.UserAdapter
import com.prasant.presentation.viewstate.UserViewState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: View
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        errorTextView = findViewById(R.id.errorTextView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the ViewModel state
        userViewModel.state.onEach { userViewState ->
            // Handle the userViewState updates
        }.launchIn(lifecycleScope)

        lifecycleScope.launch {
            userViewModel.state.collect { state ->
                when(state){
                    is UserViewState.Loading -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                        errorTextView.visibility = View.GONE
                    }
                    is UserViewState.Success -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                        errorTextView.visibility = View.GONE
                        // Set data to adapter
                        recyclerView.adapter = UserAdapter(state.users)
                    }
                    is UserViewState.Error -> {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.GONE
                        errorTextView.visibility = View.VISIBLE
                        errorTextView.text = state.error.message
                    }
                }
            }
        }
    }
}
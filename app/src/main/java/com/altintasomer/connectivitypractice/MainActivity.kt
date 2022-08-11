package com.altintasomer.connectivitypractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.altintasomer.connectivitypractice.ui.theme.ConnectivityPracticeTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainActivity : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        setContent {
            ConnectivityPracticeTheme {
                val status by connectivityObserver.observe().collectAsState(initial = ConnectivityObserver.Status.Unavailable)
                Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                    Text(text = "Network Status: $status" )
                }
            }
        }
    }
}


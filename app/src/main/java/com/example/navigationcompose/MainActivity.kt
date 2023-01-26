@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = modifier,
            value = text,
            onValueChange = {
                text = it
            }
        )
        Button(
            modifier = modifier,
            onClick = {
                navController.navigate(RouteScreen.DetailScreen.withArgs(text))
            }
        ) {
            Text("To Detail Page")
        }
        Button(
            modifier = modifier,
            onClick = {
                navController.navigate(RouteScreen.DetailScreenDialog.withArgs(text))
            }
        ) {
            Text("To Detail Dialog")
        }
    }
}


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onBack: ()-> Unit,
    name: String?
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier.padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name ?: "")
        }
    }
}


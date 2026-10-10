package com.example.mvvmwithcleanproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmwithcleanproject.domain.model.UserModel
import com.example.mvvmwithcleanproject.presentation.UserViewModel
import com.example.mvvmwithcleanproject.ui.theme.MVVMWithCleanProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

         val userViewModel: UserViewModel = hiltViewModel()
            val user by userViewModel.user.collectAsState()


            LaunchedEffect(key1 = Unit) {

                userViewModel.getUSerData()

            }

            UserDetailsScreen(
                user
            )

        }
    }
}

@Composable
fun UserDetailsScreen(user: List<UserModel>){
    LazyColumn {

        items(user){ userdata ->

            Text("ID : ${userdata.id}")
            Text("Name : ${userdata.name}")

        }


    }
}

/*@Composable
fun UserDetailsScreen(user: List<UserModel>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "User Details",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(user) { userData ->

                Text("ID: ${userData.id}")
                Text("Name: ${userData.name}")
                Text("Email: ${userData.email}")
                Text("Address: ${userData.street}, ${userData.city}")

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}*/

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMWithCleanProjectTheme {
        Greeting("Android")
    }
}*/

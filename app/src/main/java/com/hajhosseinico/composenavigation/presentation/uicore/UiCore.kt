package com.hajhosseinico.composenavigation.presentation.uicore

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hajhosseinico.composenavigation.domain.HomeFeatureModel
import com.hajhosseinico.composenavigation.domain.ScreenAboutUs
import com.hajhosseinico.composenavigation.domain.ScreenForgotPassword
import com.hajhosseinico.composenavigation.domain.ScreenHome
import com.hajhosseinico.composenavigation.domain.ScreenLogin
import com.hajhosseinico.composenavigation.domain.ScreenProductDetail
import com.hajhosseinico.composenavigation.domain.ScreenProductList
import com.hajhosseinico.composenavigation.domain.ScreenRegister
import com.hajhosseinico.composenavigation.presentation.mainactivity.MainViewModel


@Composable
fun LoginScreen(navController: NavHostController, viewModel: MainViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Username Field
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation() // Hide password input
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                navController.navigate(ScreenHome(username = username)) {
                    popUpTo(ScreenLogin) { inclusive = true } // Clear login screen
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register Text (acts like a button)
        Text(
            text = "Don't have an account? Register",
            modifier = Modifier.clickable {
                navController.navigate(ScreenRegister(username = username))
            },
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot Password Text (acts like a button)
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable {
                navController.navigate(ScreenForgotPassword(username = username))
            },
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: MainViewModel, username: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register Screen for $username",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Back to Login Button
        Button(onClick = {
            navController.popBackStack(ScreenLogin, inclusive = false)
        }) {
            Text(text = "Back to Login")
        }
    }
}

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController,
    viewModel: MainViewModel,
    username: String?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Forgot Password for $username",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to Home Button
        Button(onClick = {
            navController.navigate(ScreenHome(username = username)) {
                popUpTo(ScreenLogin) { inclusive = true } // Clear login and forgot password screens
            }
        }) {
            Text(text = "Go to Home")
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, viewModel: MainViewModel, username: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Welcome Text with Username
        Text(
            text = "Welcome $username",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Product List Button
        Button(
            onClick = { navController.navigate(ScreenProductList) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Go to Product List", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // About Us Button
        Button(
            onClick = {
                navController.navigate(ScreenAboutUs)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "About Us", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exit Button (Logout)
        Button(
            onClick = {
                navController.navigate(ScreenLogin) {
                    popUpTo(ScreenLogin) { inclusive = true } // Clear home and go to login
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Exit", color = Color.White)
        }
    }
}

@Composable
fun ProductListScreen(navController: NavHostController) {
    val productList = listOf(
        "Product 1", "Product 2", "Product 3", "Product 4", "Product 5"
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // Back Button
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back to Home")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable Product List
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(productList) { product ->
                Button(
                    onClick = {
                        // Navigate to the Product Detail screen by passing the product name
                        navController.navigate(ScreenProductDetail(productName = product))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = product, color = Color.White)
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ProductDetailScreen(navController: NavHostController, productName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Product Details
        Text(
            text = "Details of $productName",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Back Button
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back to Product List")
        }
    }
}

@Composable
fun AboutUsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back Button (Styled as an arrow)
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Introduction Text
        Text(
            text = "Hi, my name is Ali Hajhosseini!",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "I live in Ottawa, Canada, and I developed this app to make it easier for developers to use Jetpack Compose for navigation. "
                    + "My goal is to help simplify navigation in modern Android apps, making it smooth and intuitive.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Thank you for trying out this app, and I hope it helps you in your projects!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Feel free to reach out if you have any questions or feedback: hajhosseinico@gmail.com",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}


@Composable
fun FeatureItem(feature: HomeFeatureModel) {
    Text(text = feature.title, modifier = Modifier.padding(8.dp))
}


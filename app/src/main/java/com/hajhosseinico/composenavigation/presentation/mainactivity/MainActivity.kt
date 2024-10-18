package com.hajhosseinico.composenavigation.presentation.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.hajhosseinico.composenavigation.domain.ScreenAboutUs
import com.hajhosseinico.composenavigation.domain.ScreenForgotPassword
import com.hajhosseinico.composenavigation.domain.ScreenHome
import com.hajhosseinico.composenavigation.domain.ScreenLogin
import com.hajhosseinico.composenavigation.domain.ScreenProductDetail
import com.hajhosseinico.composenavigation.domain.ScreenProductList
import com.hajhosseinico.composenavigation.domain.ScreenRegister
import com.hajhosseinico.composenavigation.presentation.uicore.AboutUsScreen
import com.hajhosseinico.composenavigation.presentation.uicore.ForgotPasswordScreen
import com.hajhosseinico.composenavigation.presentation.uicore.HomeScreen
import com.hajhosseinico.composenavigation.presentation.uicore.LoginScreen
import com.hajhosseinico.composenavigation.presentation.uicore.ProductDetailScreen
import com.hajhosseinico.composenavigation.presentation.uicore.ProductListScreen
import com.hajhosseinico.composenavigation.presentation.uicore.RegisterScreen
import com.hajhosseinico.composenavigation.ui.theme.ComposeNavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                val navController = rememberNavController()
                val viewModel: MainViewModel = viewModel()

                NavHost(navController = navController, startDestination = ScreenLogin) {
                    // Login Screen
                    composable<ScreenLogin> {
                        LoginScreen(navController = navController, viewModel = viewModel)
                    }

                    // Register Screen
                    composable<ScreenRegister> {
                        val args = it.toRoute<ScreenRegister>()
                        RegisterScreen(navController = navController, viewModel = viewModel, username = args.username)
                    }

                    // Forgot Password Screen
                    composable<ScreenForgotPassword> {
                        val args = it.toRoute<ScreenForgotPassword>()
                        ForgotPasswordScreen(navController = navController, viewModel = viewModel, username = args.username)
                    }

                    // Home Screen
                    composable<ScreenHome> {
                        val args = it.toRoute<ScreenHome>()
                        HomeScreen(navController = navController, viewModel = viewModel, username = args.username)
                    }

                    // Product List Screen
                    composable<ScreenProductList> {
                        ProductListScreen(navController = navController)
                    }

                    // Product Detail Screen
                    composable<ScreenProductDetail> {
                        val args = it.toRoute<ScreenProductDetail>()
                        ProductDetailScreen(navController = navController, productName = args.productName)
                    }

                    // About Us Screen
                    composable<ScreenAboutUs> {
                        AboutUsScreen(navController = navController)
                    }
                }
            }
        }
    }
}
package com.hajhosseinico.composenavigation.domain

import kotlinx.serialization.Serializable

data class HomeFeatureModel(
    val id: String,
    val title: String
)

@Serializable
object ScreenLogin

@Serializable
data class ScreenRegister(
    val username: String?
)

@Serializable
data class ScreenForgotPassword(
    val username: String?
)

@Serializable
data class ScreenHome(
    val username: String?
)

@Serializable
object ScreenProductList

@Serializable
data class ScreenProductDetail(
    val productName: String
)

@Serializable
object ScreenAboutUs




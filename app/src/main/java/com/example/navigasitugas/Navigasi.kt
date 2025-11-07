navigasi.kt

package com.example.navigasitugas


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasitugas.view.Awal
import com.example.navigasitugas.view.TampilData
import com.example.navigasitugas.view.Form


enum class Navigasi {
    Formulirku,
    Detail,
    Homepage,
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Homepage.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {

            composable(route = Navigasi.Homepage.name) {
                Awal(
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        navController.popBackStack(
                            route = Navigasi.Homepage.name,
                            inclusive = false
                        )
                    },
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Formulirku.name)
                    }
                )
            }

            composable(route = Navigasi.Formulirku.name) {
                Form(
                    onBackBtnClick = {
                        navController.popBackStack(
                            route = Navigasi.Detail.name,
                            inclusive = false
                        )
                    },
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Homepage.name) {
                            popUpTo(Navigasi.Homepage.name)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}



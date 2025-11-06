package com.example.navigasisederhana

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasisederhana.ui.theme.NavigasiSederhanaTheme

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name){
                FormIsian (
                    onSubmitBtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {cancelAndBackToFormulir(navController)}
                )

            }
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavController
) {
    navController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}
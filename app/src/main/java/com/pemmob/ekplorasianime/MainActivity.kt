package com.pemmob.ekplorasianime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.ekplorasianime.data.api.ApiService
import com.pemmob.ekplorasianime.data.repository.AnimeRepository
import com.pemmob.ekplorasianime.ui.screen.DetailScreen
import com.pemmob.ekplorasianime.ui.screen.HomeScreen
import com.pemmob.ekplorasianime.ui.theme.AnimeExplorerTheme
import com.pemmob.ekplorasianime.ui.viewmodel.AnimeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiService.create()
        val repository = AnimeRepository(apiService)
        val viewModel = AnimeViewModel(repository)

        setContent {
            AnimeExplorerTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        val homeState by viewModel.homeState.collectAsState()
                        HomeScreen(
                            state = homeState,
                            onAnimeClick = { animeId ->
                                viewModel.fetchAnimeDetail(animeId)
                                navController.navigate("detail/$animeId")
                            },
                            onRetry = { viewModel.fetchAnimeList() }
                        )
                    }

                    composable(
                        route = "detail/{animeId}",
                        arguments = listOf(navArgument("animeId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val animeId = backStackEntry.arguments?.getString("animeId") ?: ""
                        val detailState by viewModel.detailState.collectAsState()

                        DetailScreen(
                            state = detailState,
                            onBack = { navController.popBackStack() },
                            onRetry = { viewModel.fetchAnimeDetail(animeId) }
                        )
                    }
                }
            }
        }
    }
}

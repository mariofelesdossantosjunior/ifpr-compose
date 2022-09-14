package com.mario.pokemonifpr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mario.pokemonifpr.data.PokemonAPI
import com.mario.pokemonifpr.ui.theme.PokemonIfprTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonIfprTheme {
                val pokemons = PokemonAPI.loadPokemon()
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ) {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(
                            pokemons = pokemons
                        )
                    }
                }
            }
        }
    }
}
package com.mario.pokemonifpr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mario.pokemonifpr.data.Pokemon
import com.mario.pokemonifpr.components.ListPokemon
import com.mario.pokemonifpr.components.SearchBar

@Composable
fun PokemonListScreen(
    pokemons: List<Pokemon>
) {
    val pokemonFilters = remember {
        mutableStateOf(pokemons)
    }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {

        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_pokemon),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Procurar...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) { query ->
                if (query.isBlank()) {
                    pokemonFilters.value = pokemons
                } else {
                    val filtered = pokemons.filter { it.name.startsWith(query, ignoreCase = true) }
                    pokemonFilters.value = filtered
                }
            }
            ListPokemon(pokemons = pokemonFilters.value)
        }
    }
}






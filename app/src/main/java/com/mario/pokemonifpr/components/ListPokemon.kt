package com.mario.pokemonifpr.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mario.pokemonifpr.data.Pokemon
import com.mario.pokemonifpr.data.PokemonAPI

@Preview
@Composable
fun PreviewListPokemon() {
    val fakePokemons = PokemonAPI.loadPokemon()
    ListPokemon(pokemons = fakePokemons)
}

@Composable
fun ListPokemon(pokemons: List<Pokemon>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(pokemons) { pokemon ->
            CardPokemon(pokemon)
        }
    }
//    LazyRow(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        items(pokemons) { pokemon ->
//            CardPokemon(pokemon)
//        }
//    }
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(2)
//    ) {
//        items(pokemons) { pokemon ->
//            CardPokemon(pokemon)
//        }
//    }
}

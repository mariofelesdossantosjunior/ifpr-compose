package com.mario.pokemonifpr.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mario.pokemonifpr.data.Pokemon
import com.mario.pokemonifpr.data.PokemonAPI
import com.mario.pokemonifpr.data.color

@Preview
@Composable
fun PreviewCard() {
    val fakePokemon = PokemonAPI.fakeCharmander
    CardPokemon(pokemon = fakePokemon)
}

@Composable
fun CardPokemon(pokemon: Pokemon) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = colorResource(id = pokemon.color()),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = "pokemon",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = pokemon.name ?: "",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
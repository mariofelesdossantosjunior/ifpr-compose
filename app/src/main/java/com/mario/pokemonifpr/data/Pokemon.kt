package com.mario.pokemonifpr.data

import com.mario.pokemonifpr.R

data class Pokemon(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val typeOfPokemon: List<String> = emptyList(),
    val category: String = "",
    val image: Int = 0,
    val hp: Int = 0,
    val attack: Int = 0,
    val defense: Int = 0,
    val specialAttack: Int = 0,
    val specialDefense: Int = 0,
    val speed: Int = 0,
    val total: Int = 0
)

fun Pokemon.color(): Int {
    val type = typeOfPokemon.elementAtOrNull(0)

    return when (type?.lowercase()) {
        "grass", "bug" -> R.color.poke_light_teal
        "fire" -> R.color.poke_light_red
        "water", "fighting", "normal" -> R.color.poke_light_blue
        "electric", "psychic" -> R.color.poke_light_yellow
        "poison", "ghost" -> R.color.poke_light_purple
        "ground", "rock" -> R.color.poke_light_brown
        "dark" -> R.color.poke_black
        else -> return R.color.poke_light_blue
    }
}

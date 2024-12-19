package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
static final Map<Integer, String> POKEMON_NAMES = new HashMap<>() {{
        put(-1, "Ash's Pikachu");
        put(0, "MISSINGNO");
        put(1, "Bulbasaur");
    }};

    private final Random random = new Random();

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name = POKEMON_NAMES.getOrDefault(index, "YA PAS BOUFFON");
        int[] ivs = {10, 20, 30};
        double iv = ((ivs[0] + ivs[1] + ivs[2]) / 45.0) * 100;;
        return new Pokemon(
                index,
                name,
                ivs[0] * 15,
                ivs[1] * 15,
                ivs[2] * 15,
                cp,
                hp,
                dust,
                candy,
                iv
        );
    }
}
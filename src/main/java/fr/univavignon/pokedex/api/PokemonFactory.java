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

    private int[] generateIVs() {

        int attack = random.nextInt(16);     // IV entre 0 et 15
        int defense = random.nextInt(16);    // IV entre 0 et 15
        int stamina = random.nextInt(16);    // IV entre 0 et 15
        return new int[]{attack, defense, stamina};
    }

    private double calculateTotalIV(int[] ivs) {
        return ((ivs[0] + ivs[1] + ivs[2]) / 45.0) * 100;
    }
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name = POKEMON_NAMES.getOrDefault(index, "YA PAS BOUFFON");
        int[] ivs = generateIVs();
        double iv = calculateTotalIV(ivs);
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
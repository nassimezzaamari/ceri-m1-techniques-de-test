package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private Pokemon validMetadata;

    @Before
    public void setUp() throws PokedexException {
        pokemonFactory = new RocketPokemonFactory();
        validMetadata = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testValidCP() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(validMetadata.getCp(), actualMetadata.getCp());
    }

    @Test
    public void testValidHP() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(validMetadata.getHp(), actualMetadata.getHp());
    }

    @Test
    public void testValidDust() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(validMetadata.getDust(), actualMetadata.getDust());
    }

    @Test
    public void testValidCandy() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(validMetadata.getCandy(), actualMetadata.getCandy());
    }


    @Test
    public void testCreateValidPokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 50, 2000, 3);

        assertNotNull(pokemon);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(1, pokemon.getIndex());
        assertEquals(500, pokemon.getCp());
        assertEquals(50, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
        assertEquals(1.0, pokemon.getIv(), 0.001);
    }

    @Test
    public void testCreateAshPikachu() {
        Pokemon pokemon = pokemonFactory.createPokemon(-1, 500, 50, 2000, 3);

        assertNotNull(pokemon);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(-1, pokemon.getIndex());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.001);
    }

    @Test
    public void testCreateMissingno() {
        Pokemon pokemon = pokemonFactory.createPokemon(999, 500, 50, 2000, 3);

        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName());
        assertEquals(999, pokemon.getIndex());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
    }

    @Test
    public void testRandomStatGeneration() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 50, 2000, 3);

        assertTrue(
                pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(
                pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(
                pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
    }

    @Test
    public void testMultipleRandomPokemon() {
        // Test de la RNG
        Pokemon pokemon1 = pokemonFactory.createPokemon(1, 500, 50, 2000, 3);
        Pokemon pokemon2 = pokemonFactory.createPokemon(1, 500, 50, 2000, 3);

        boolean allStatsIdentical =
                pokemon1.getAttack() == pokemon2.getAttack() &&
                        pokemon1.getDefense() == pokemon2.getDefense() &&
                        pokemon1.getStamina() == pokemon2.getStamina();

        assertFalse(allStatsIdentical);
    }
}

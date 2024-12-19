package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IRocketPokemonFactoryTest {

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
}
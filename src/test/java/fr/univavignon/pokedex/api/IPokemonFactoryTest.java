package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void before() throws PokedexException {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));

    }

    @Test
    public void testBulbi() throws PokedexException {
        Pokemon bulbi = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", bulbi.getName());
        assertEquals(126, bulbi.getAttack());
        assertEquals(126, bulbi.getDefense());
        assertEquals(90, bulbi.getStamina());
        // Le vrai test commence ici...
        assertEquals(613, bulbi.getCp());
        assertEquals(64, bulbi.getHp());
        assertEquals(4000, bulbi.getDust());
        assertEquals(4, bulbi.getCandy());
    }



}

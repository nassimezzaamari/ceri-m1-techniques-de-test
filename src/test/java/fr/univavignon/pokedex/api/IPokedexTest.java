package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    //private Pokemon aquali;
    private Pokemon bulbizarre;
    private PokemonMetadata bulbiMetaData;

    private IPokedex pokedex;

    @BeforeEach
    public void before() throws PokedexException {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        bulbiMetaData = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokedex = Mockito.mock(IPokedex.class);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.getPokemon(151)).thenThrow(new PokedexException("Pokemon n'existe pas bouffon"));
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.size()).thenReturn(1);
        when(pokedex.getPokemonMetadata(0)).thenReturn(bulbiMetaData);
        when(pokedex.getPokemonMetadata(151)).thenThrow(new PokedexException("Pokemon n'existe pas bouffon"));

    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(0, pokedex.addPokemon(bulbizarre));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
    }

    @Test
    public void testGetSize() throws PokedexException {
        // Bon théoriquement ca a pas beaucoup de sens, parfois on part du principe
        // que le Pokedex est "populated", parfois non...
        pokedex.addPokemon(bulbizarre);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetNonExistingPokemon() throws PokedexException
    {
        assertThrows(PokedexException.class, () ->
        {
            pokedex.getPokemon(151);
        });
    }

    @Test
    public void testGetMetaData() throws PokedexException {
        assertEquals(bulbiMetaData, pokedex.getPokemonMetadata(0));
    }

    @Test
    public void testGetNonExistingMetaData() throws PokedexException
    {
        assertThrows(PokedexException.class, () ->
        {
            pokedex.getPokemonMetadata(151);
        });
    }

}

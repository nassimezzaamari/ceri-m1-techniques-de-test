package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void before() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(pokemonMetadataProvider.getPokemonMetadata(133))
                .thenReturn(new PokemonMetadata(0, "Aquali", 186, 168, 260));
        when(pokemonMetadataProvider.getPokemonMetadata(151))
                .thenThrow(new PokedexException("Pokemon n'existe pas bouffon"));
    }

    @Test
    public void testBulbi() throws PokedexException {
        PokemonMetadata bulbi = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", bulbi.getName());
        assertEquals(126, bulbi.getAttack());
        assertEquals(126, bulbi.getDefense());
        assertEquals(90, bulbi.getStamina());
    }

    @Test
    public void testAquali() throws PokedexException {
        PokemonMetadata aquali = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals("Aquali", aquali.getName());
        assertEquals(186, aquali.getAttack());
        assertEquals(168, aquali.getDefense());
        assertEquals(260, aquali.getStamina());
    }

    @Test
    public void testPokemonNull() throws PokedexException {
        assertThrows(PokedexException.class, () ->
        {
            pokemonMetadataProvider.getPokemonMetadata(151);
        });
    }


}

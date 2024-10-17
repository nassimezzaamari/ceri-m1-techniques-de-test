package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokemonTrainerFactory pokemonTrainerFactory;
    private PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void before() throws PokedexException {
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokemonTrainer = Mockito.mock(PokemonTrainer.class);
        when(pokemonTrainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() throws PokedexException {
        assertNotNull(pokemonTrainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory));
    }


}

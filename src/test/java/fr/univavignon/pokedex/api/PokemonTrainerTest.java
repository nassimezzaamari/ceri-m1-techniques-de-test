package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class PokemonTrainerTest {

    private String TRAINER_NAME = "Ash";
    private Team team;
    private IPokedex pokedex;
    private PokemonTrainer trainer;

    @Before
    public void setUp() {
        team = mock(Team.class);
        pokedex = mock(IPokedex.class);
        trainer = new PokemonTrainer(TRAINER_NAME, team, pokedex);
    }

    @Test
    public void testGetName() {
        assertEquals(TRAINER_NAME, trainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertEquals(team, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    public void testConstructorWithNullName() {
        trainer = new PokemonTrainer(null, team, pokedex);
        assertNull(trainer.getName());
    }

    @Test
    public void testConstructorWithNullTeam() {
        trainer = new PokemonTrainer(TRAINER_NAME, null, pokedex);
        assertNull(trainer.getTeam());
    }

    @Test
    public void testConstructorWithNullPokedex() {
        trainer = new PokemonTrainer(TRAINER_NAME, team, null);
        assertNull(trainer.getPokedex());
    }

    @Test
    public void testEquivalentTrainers() {
        PokemonTrainer trainer1 = new PokemonTrainer(TRAINER_NAME, team, pokedex);
        PokemonTrainer trainer2 = new PokemonTrainer(TRAINER_NAME, team, pokedex);
        assertEquals(trainer1.getName(), trainer2.getName());
        assertEquals(trainer1.getTeam(), trainer2.getTeam());
        assertEquals(trainer1.getPokedex(), trainer2.getPokedex());
    }
}
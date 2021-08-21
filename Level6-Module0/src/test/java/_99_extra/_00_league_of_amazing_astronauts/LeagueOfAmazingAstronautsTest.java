package _99_extra._00_league_of_amazing_astronauts;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {

    @Mock
    Rocketship rocketship;
    
    @Mock
    Astronaut astronaut;
    
    LeagueOfAmazingAstronauts underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new LeagueOfAmazingAstronauts();
    }

    @Test
    void itShouldPrepareAstronaut() {
        //given
        when(astronaut.isTrained()).thenReturn(true);

        //when
        underTest.prepareAstronaut(astronaut);

        //then
        verify(astronaut, times(1)).train();
    }

    @Test
    void itShouldLaunchRocket() {
        //given
        String destination = "Mars";
        when(rocketship.isLoaded()).thenReturn(true);

        //when
        underTest.setRocketship(rocketship);
        underTest.launchRocket(destination);

        //then
        verify(rocketship, times(1)).launch();
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
        String destination = "Altra-B478";
        when(rocketship.isLoaded()).thenReturn(true);

        //when
        underTest.setRocketship(rocketship);

        //then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> underTest.launchRocket(destination));
        assertTrue(exceptionThrown.getClass().equals(IllegalArgumentException.class));
        assertEquals(exceptionThrown.getMessage(), "Destination is unavailable");
        verify(rocketship, never()).launch();
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
        String destination = "Mars";
        when(rocketship.isLoaded()).thenReturn(false);

        //when
        //then
        Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> underTest.launchRocket(destination));
        assertTrue(exceptionThrown.getClass().equals(IllegalStateException.class));
        assertEquals(exceptionThrown.getMessage(), "Rocketship is not loaded");
        verify(rocketship, never()).launch();
    }
}
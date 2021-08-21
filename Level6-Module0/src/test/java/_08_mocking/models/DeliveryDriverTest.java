package _08_mocking.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.Engine;
import _07_intro_to_mocking.models.GasTank;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;

    @Mock
    Car car;
    
    @Mock
    GasTank gas;
    
    @Mock
    CellPhone cell;
    
    @Mock
    Engine engine;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        deliveryDriver = new DeliveryDriver("Daniel", car, cell);
    }

    @Test
    void itShouldWasteTime() {
        //given
        when(cell.browseCatMemes()).thenReturn(true);
        boolean expected = true;
        
        //when
        boolean actual = deliveryDriver.wasteTime();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldRefuel() {
        //given
        when(car.fillTank(12)).thenReturn(true);
        when(car.fillTank(-1)).thenReturn(false);
        boolean expected = true;
        boolean expectedFalse = false;

        //when
        boolean actual = deliveryDriver.refuel(12);
        boolean actualFalse = deliveryDriver.refuel(-1);

        //then
        assertEquals(expected, actual);
        assertEquals(expectedFalse, actualFalse);
    }

    @Test
    void itShouldContactCustomer() {
        //given
        when(cell.call("(555) 123-4567")).thenReturn(true);
        when(cell.call("(555) 987-6543")).thenReturn(false);
        boolean expected = true;
        boolean expectedFalse = false;

        //when
        boolean actual = deliveryDriver.contactCustomer("(555) 123-4567");
        boolean actualFalse = deliveryDriver.contactCustomer("(555) 987-6543");

        //then
        assertEquals(expected, actual);
        assertEquals(expectedFalse, actualFalse);
    }

}
package _10_white_box_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;

class MyDonutShopTest {

    MyDonutShop myDonutShop;

    @Mock
    PaymentService paymentService;
    
    @Mock
    DeliveryService deliveryService;
    
    @Mock
    BakeryService bakeryService;
    
    @Mock
    Order order;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
        when(order.isDelivery()).thenReturn(true);
        when(paymentService.charge(order)).thenReturn(true);

        //when
        myDonutShop.openForTheDay();
        myDonutShop.takeOrder(order);

        //then
        verify(deliveryService, times(1)).scheduleDelivery(order);
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
        when(order.getNumberOfDonuts()).thenReturn(51);

        //when
        myDonutShop.openForTheDay();

        //then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Insufficient donuts remaining");
        verify(paymentService, never()).charge(any());
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException() {
        //given
        when(order.getNumberOfDonuts()).thenReturn(1);

        //when
        myDonutShop.closeForTheDay();

        //then
        Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Sorry we're currently closed");
        verify(paymentService, never()).charge(any());
    }
}
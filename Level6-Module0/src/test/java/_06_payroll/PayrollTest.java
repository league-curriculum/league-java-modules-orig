package _06_payroll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
        int hours = 40;
        int ratePerHour = 20;

        //when
        double earnDollars = hours * ratePerHour;

        //then
        assertEquals(earnDollars, payroll.calculatePaycheck(hours, ratePerHour), 0.01);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given

        //when

        //then
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given

        //when

        //then
    }

}
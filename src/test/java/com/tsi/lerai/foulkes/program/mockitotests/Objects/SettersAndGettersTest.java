package com.tsi.lerai.foulkes.program.mockitotests.Objects;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SettersAndGettersTest {
    Payment paymentTest = new Payment();

    @Test
    public void paymentSettersAndGetters(){
        paymentTest.setPayment_id(0L);
        Long expectedPaymentID = 0L;
        Long actualPaymentID = paymentTest.getPayment_id();
        Assertions.assertEquals(expectedPaymentID,actualPaymentID,"Payment ID's do not match");
        paymentTest.setPayment_date(LocalDate.of(1998,12,21));
        LocalDate expectedDate = LocalDate.of(1998,12,21) ;
        LocalDate actualDate = paymentTest.getPayment_date();
        paymentTest.setAmount(200);
        float expectedAmount = 200 ;
        float actualAmount = paymentTest.getAmount() ;
        Assertions.assertEquals(expectedAmount,actualAmount);
       paymentTest.setCustomer_id(15);
       int expectedCustomerId = 15 ;
       int actualCustomerId = paymentTest.getCustomer_id();
       Assertions.assertEquals(expectedCustomerId,actualCustomerId);
       paymentTest.setRental_id(10L);
       Long expectedRentalId = 10L ;
       Long actualRentalId = paymentTest.getRental_id() ;
       Assertions.assertEquals(expectedRentalId,actualRentalId,"Rental Id's do not match ");
       paymentTest.setStaff_id(3);
       int expectedStaffId = 3 ;
       int actualStaffId = paymentTest.getStaff_id() ;
       Assertions.assertEquals(expectedStaffId,actualStaffId,"Staff Id's do not match");
       paymentTest.setCustomer_id(5);
        int expectedCustomerid = 5 ;
        int actualCustomerid = paymentTest.getCustomer_id();
        Assertions.assertEquals(expectedCustomerid,actualCustomerid,"Customer ID's do not match");
    }
}

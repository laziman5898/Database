package com.tsi.lerai.foulkes.program.mockitotests.Objects;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import com.tsi.lerai.foulkes.program.repoandobj.staff.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SettersAndGettersTest {
    Payment paymentTest = new Payment();
    Staff staffTest ;
    Movie movieTest ;

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

    @Test
    public void  staffSettersandGetter () {
        staffTest = new Staff("James" , "Bond" , 5 , "John@aol.com") ;

        staffTest.setStaff_id(1L);
        Assertions.assertEquals(1L,staffTest.getStaff_id());
        staffTest.setAddress_id(2);
        Assertions.assertEquals(2,staffTest.getAddress_id());
        staffTest.setEmail("Override@aol.com");
        String expectedEmail = "Override@aol.com" ;
        String actualEmail = staffTest.getEmail();
        staffTest.setFirst_name("Master");
        String expectedFirstName = "Master";
        String actualFirstName = staffTest.getFirst_name();
        Assertions.assertEquals(expectedFirstName,actualFirstName);
        staffTest.setLast_name("Obi-wan");
        String expectedLastName = "Obi-wan";
        String actualLastname = staffTest.getLast_name();
        Assertions.assertEquals(expectedLastName,actualLastname);
    }

    @Test
    public void movieSettersAndGetters () {
        movieTest = new Movie("James Bond",200 ,"PG");
        movieTest.setFilm_id(1L);
        Assertions.assertEquals(1L,movieTest.getFilm_id());
        movieTest.setCategory("Action");
        Assertions.assertEquals("Action",movieTest.getCategory());
        movieTest.setTitle("Aquaman");
        Assertions.assertEquals("Aquaman",movieTest.getTitle());
        movieTest.setSpecial_features("Deleted Scenes");
        Assertions.assertEquals("Deleted Scenes",movieTest.getSpecial_features());
        movieTest.setLanguage_id(2);
        Assertions.assertEquals(2,movieTest.getLanguage_id());
        movieTest.setDescription("Masterpiece");
        Assertions.assertEquals("Masterpiece",movieTest.getDescription());
        movieTest.setLast_update(LocalDate.of(1999,1,20));
        Assertions.assertEquals(LocalDate.of(1999,1,20), movieTest.getLast_update());
        movieTest.setRating("18+");
        Assertions.assertEquals("18+",movieTest.getRating());
        movieTest.setLength(200);
        Assertions.assertEquals(200, movieTest.getLength());
        movieTest.setReplacement_cost(1020);
        Assertions.assertEquals(1020, movieTest.getReplacement_cost());
        movieTest.setRental_rate(29);
        Assertions.assertEquals(29, movieTest.getRental_rate());
        movieTest.setRelease_year(2003);
        Assertions.assertEquals(2003 , movieTest.getRelease_year());
        movieTest.setRental_duration(200);
        Assertions.assertEquals(200 , movieTest.getRental_duration());
    }

}

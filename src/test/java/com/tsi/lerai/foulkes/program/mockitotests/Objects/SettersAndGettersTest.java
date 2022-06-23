package com.tsi.lerai.foulkes.program.mockitotests.Objects;

import ch.qos.logback.core.net.AbstractSSLSocketAppender;
import com.tsi.lerai.foulkes.program.repoandobj.customer.Customer;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActor;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategory;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.Inventory;
import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import com.tsi.lerai.foulkes.program.repoandobj.staff.Staff;
import com.tsi.lerai.foulkes.program.repoandobj.store.Store;
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

    Inventory inventoryTest ;
    Store storeTest ;
    FilmCategory filmCategoryTest ;
    Customer customerTest;
    FilmActor filmActorTest;

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

    @Test
    public void inventorySettersAndGettersTest(){
        inventoryTest = new Inventory(2 ,2);
        inventoryTest.setInventory_id(3L);
        Assertions.assertEquals(3L,inventoryTest.getInventory_id());
        inventoryTest.setFilm_id(2);
        Assertions.assertEquals(2,inventoryTest.getFilm_id());
        inventoryTest.setStore_id(2);
        Assertions.assertEquals(2,inventoryTest.getStore_id());
    }

    @Test
    public void storeSettersAndGettersTest (){
        storeTest = new Store(2,2);
        storeTest.setStore_id(1);
        Assertions.assertEquals(1,storeTest.getStore_id());
        storeTest.setAddress_id(7);
        Assertions.assertEquals(7, storeTest.getAddress_id());
        storeTest.setManager_staff_id(5);
        Assertions.assertEquals(5,storeTest.getManager_staff_id());
    }

    @Test
    public void filmCategoryTest () {
        filmCategoryTest = new FilmCategory() ;
        filmCategoryTest.setCategory_id(1);
        Assertions.assertEquals(1,filmCategoryTest.getCategory_id());
        filmCategoryTest.setFilm_id(2L);
        Assertions.assertEquals(2L,filmCategoryTest.getFilm_id());
    }
    @Test
    public void setCustomerTest(){
        customerTest = new Customer("James","Brown" , "Brown@email.com","password",2,2,2);
        customerTest.setCustomer_id(1L);
        Assertions.assertEquals(1L,customerTest.getCustomer_id());
        customerTest.setEmail("email@change.com");
        Assertions.assertEquals("email@change.com",customerTest.getEmail());
        customerTest.setFirst_name("Tom");
        Assertions.assertEquals("Tom", customerTest.getFirst_name());
        customerTest.setAddress_id(2);
        Assertions.assertEquals(2,customerTest.getAddress_id());
        customerTest.setLast_name("Green");
        Assertions.assertEquals("Green",customerTest.getLast_name());
        customerTest.setLast_update(LocalDate.of(2020,1,21));
        Assertions.assertEquals(LocalDate.of(2020,1,21),customerTest.getLast_update());
        customerTest.setPassword("newPassword");
        Assertions.assertEquals("newPassword",customerTest.getPassword());
        customerTest.setStore_id(2);
        Assertions.assertEquals(2,customerTest.getStore_id());
        customerTest.setActor_id(34L);
        Assertions.assertEquals(34L, customerTest.getActor_id());
        customerTest.setLast_update(LocalDate.of(2020,1,21));
        Assertions.assertEquals(LocalDate.of(2020,1,21),customerTest.getLast_update());
        customerTest.setCreate_date(LocalDate.of(2020,1,21));
        Assertions.assertEquals(LocalDate.of(2020,1,21), customerTest.getCreate_date());
    }
    @Test
    public void setFilmActorTest(){
        filmActorTest = new FilmActor(2);
        filmActorTest.setActor_id(5L);
        Assertions.assertEquals(5L,filmActorTest.getActor_id());
        filmActorTest.setFilm_id(3);
        Assertions.assertEquals(3,filmActorTest.getFilm_id());
    }

}

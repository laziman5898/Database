package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.PaymentController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import com.tsi.lerai.foulkes.program.repoandobj.payment.PaymentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoPaymentControllerTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private PaymentRepo paymentRepo;
    @InjectMocks
    PaymentController paymentController ;
    @BeforeEach
    void setup(){
        paymentRepo = mock(PaymentRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        paymentController=new PaymentController(paymentRepo);
    }

    @Test
    public void getAllPaymentInfo(){
        //Setup Mock Enviroment for actorRepo
        List<Payment> list = new ArrayList<Payment>();
        Payment dummyPayment = new Payment() ;
        list.add(dummyPayment);
        when(paymentRepo.findAll()).thenReturn(list);
        List<Payment> expected = list;
        List<Payment> actual = paymentController.getAllPaymentInfo();
        //Tests
        verify(paymentRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");
    }
}

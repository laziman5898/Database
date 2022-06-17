package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.controller.*;
import com.tsi.lerai.foulkes.program.repoandobj.CompleteRepo;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.InventoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import com.tsi.lerai.foulkes.program.repoandobj.payment.Payment;
import com.tsi.lerai.foulkes.program.repoandobj.payment.PaymentRepo;
import com.tsi.lerai.foulkes.program.repoandobj.staff.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CompleteController {
    @Autowired
    private ActorRepo actorRepo ;
    private CompleteRepo completeRepo = new CompleteRepo() ;
    private ActorController actorController;
    private CategoryController categoryController ;
    private CustomerController customerController;
    private FilmActorController filmActorController;
    private FilmCategoryController filmCategoryController ;
    private InventoryController inventoryController ;
    private MovieController movieController ;
    private PaymentController paymentController ;
    private StaffController staffController ;
    private StoreController storeController ;

    public CompleteController () {
       actorController = new ActorController(completeRepo.getActorRepo());
        categoryController= new CategoryController(completeRepo.getCategoryRepo());
        customerController= new CustomerController(completeRepo.getCustomerRepo());
        filmActorController = new FilmActorController(completeRepo.getFilmActorRepo());
        filmCategoryController = new FilmCategoryController(completeRepo.getFilmCategoryRepo());
        inventoryController = new InventoryController(completeRepo.getInventoryRepo());
        movieController = new MovieController(completeRepo.getMovieRepo());
        paymentController = new PaymentController(completeRepo.getPaymentRepo());
        staffController = new StaffController(completeRepo.getStaffRepo());
        staffController = new StaffController(completeRepo.getStaffRepo());


    }

    public ActorController getActorController() {
        return actorController;
    }

    public void setActorController(ActorController actorController) {
        this.actorController = actorController;
    }

    public CategoryController getCategoryController() {
        return categoryController;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    public FilmActorController getFilmActorController() {
        return filmActorController;
    }

    public void setFilmActorController(FilmActorController filmActorController) {
        this.filmActorController = filmActorController;
    }

    public FilmCategoryController getFilmCategoryController() {
        return filmCategoryController;
    }

    public void setFilmCategoryController(FilmCategoryController filmCategoryController) {
        this.filmCategoryController = filmCategoryController;
    }

    public InventoryController getInventoryController() {
        return inventoryController;
    }

    public void setInventoryController(InventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public void setMovieController(MovieController movieController) {
        this.movieController = movieController;
    }

    public PaymentController getPaymentController() {
        return paymentController;
    }

    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    public StaffController getStaffController() {
        return staffController;
    }

    public void setStaffController(StaffController staffController) {
        this.staffController = staffController;
    }

    public StoreController getStoreController() {
        return storeController;
    }

    public void setStoreController(StoreController storeController) {
        this.storeController = storeController;
    }

}

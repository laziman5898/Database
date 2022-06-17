package com.tsi.lerai.foulkes.program.repoandobj;

import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.category.CategoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.customer.CustomerRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.InventoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import com.tsi.lerai.foulkes.program.repoandobj.payment.PaymentRepo;
import com.tsi.lerai.foulkes.program.repoandobj.staff.StaffRepo;
import com.tsi.lerai.foulkes.program.repoandobj.store.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteRepo {
    @Autowired
    private ActorRepo actorRepo ;
    @Autowired
    private CategoryRepo categoryRepo ;
    private CustomerRepo customerRepo ;
    private FilmActorRepo filmActorRepo;
    private FilmCategoryRepo filmCategoryRepo ;
    private InventoryRepo inventoryRepo ;
    private MovieRepo movieRepo ;
    private PaymentRepo paymentRepo ;
    private StaffRepo staffRepo ;
    private StoreRepo storeRepo ;

    public CompleteRepo (){}

    public ActorRepo getActorRepo() {
        return actorRepo;
    }

    public void setActorRepo(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }

    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public FilmActorRepo getFilmActorRepo() {
        return filmActorRepo;
    }

    public void setFilmActorRepo(FilmActorRepo filmActorRepo) {
        this.filmActorRepo = filmActorRepo;
    }

    public FilmCategoryRepo getFilmCategoryRepo() {
        return filmCategoryRepo;
    }

    public void setFilmCategoryRepo(FilmCategoryRepo filmCategoryRepo) {
        this.filmCategoryRepo = filmCategoryRepo;
    }

    public InventoryRepo getInventoryRepo() {
        return inventoryRepo;
    }

    public void setInventoryRepo(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public MovieRepo getMovieRepo() {
        return movieRepo;
    }

    public void setMovieRepo(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public PaymentRepo getPaymentRepo() {
        return paymentRepo;
    }

    public void setPaymentRepo(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public StaffRepo getStaffRepo() {
        return staffRepo;
    }

    public void setStaffRepo(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    public StoreRepo getStoreRepo() {
        return storeRepo;
    }

    public void setStoreRepo(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }
}

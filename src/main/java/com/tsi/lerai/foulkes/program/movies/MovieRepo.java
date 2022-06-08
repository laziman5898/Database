package com.tsi.lerai.foulkes.program.movies;

import com.tsi.lerai.foulkes.program.Actor;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie,Long> {
}

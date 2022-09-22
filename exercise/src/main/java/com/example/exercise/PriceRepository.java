package com.example.exercise;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {
    Optional<Price> findByName(String name);
    boolean existsPriceByName(String name);
    void deleteByName(String name);
}

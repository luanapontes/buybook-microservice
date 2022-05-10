package com.microservice.buybook.buybookmicroservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyBookRepository extends JpaRepository<BuyBook, Long> {

    List<BuyBook> findBuyBookByStatus(Status status);
}

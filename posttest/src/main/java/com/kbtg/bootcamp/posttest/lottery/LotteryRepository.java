package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Long> {
    @Query(value = "SELECT ticketid FROM lottery", nativeQuery = true)
    List<Object[]> getTicketID();
}
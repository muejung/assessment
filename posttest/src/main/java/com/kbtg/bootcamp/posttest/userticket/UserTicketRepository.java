package com.kbtg.bootcamp.posttest.userticket;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTicketRepository extends JpaRepository <UserTicket, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_ticket(userId, ticketId, amount, price) VALUES (:userid, :ticketId, 1, 80)", nativeQuery = true)
    void buyTicketeById(@Param("userid") String userId, @Param("ticketId") String ticketId);

    @Query(value = "SELECT MAX(id) FROM user_ticket", nativeQuery = true)
    Long getLastUserTicket();

    @Query(value = "SELECT ticketid, SUM(amount) AS count, SUM(price) AS cost FROM user_ticket WHERE userid = :userid GROUP BY ticketid", nativeQuery = true)
    List<Object[]> getAllTicket(@Param("userid") String userId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_ticket WHERE userid = :userid AND ticketid = :ticketId", nativeQuery = true)
    void deleteTicketeById(@Param("userid") String userId, @Param("ticketId") String ticketId);
}

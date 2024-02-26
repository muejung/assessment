package com.kbtg.bootcamp.posttest.userticket;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kbtg.bootcamp.posttest.utils.getTicketToString.getTicketToString;
import static com.kbtg.bootcamp.posttest.utils.numberValidation.isLotteryPattern;
import static com.kbtg.bootcamp.posttest.utils.numberValidation.isUserPattern;

@Service
public class UserTicketService {
    @Autowired
    private UserTicketRepository userTicketRepository;

    @Transactional
    public ResponseEntity<String> buyLottery(String userId, String ticketId) {
        if(isUserPattern(userId)) {
            if (isLotteryPattern(ticketId)) {
                userTicketRepository.buyTicketeById(userId, ticketId);
                Long lastUserTicket = userTicketRepository.getLastUserTicket();
                return ResponseEntity.ok("\"id\": \"" + lastUserTicket + "\"");

            } else {
                return ResponseEntity.badRequest().body("\"Lottery must contain 6 digits without spaces\"");
            }
        } else {
            return ResponseEntity.badRequest().body("\"UserId must contain 10 digits without spaces\"");
        }
    }

    public List<String> allTicketbyUser(String userId) {
        List<Object[]> allTicket = userTicketRepository.getAllTicket(userId);
        return  getTicketToString(allTicket);
    }

    @Transactional
    public ResponseEntity<String> deleteTicketbyUser(String userId, String ticketId) {
        if(isUserPattern(userId)) {
            if (isLotteryPattern(ticketId)) {
                int ticketDeleted = userTicketRepository.deleteTicketeById(userId, ticketId);
                if (ticketDeleted > 0) {
                    userTicketRepository.deleteTicketeById(userId, ticketId);
                    return ResponseEntity.ok("\"tickets\": \"" + ticketId + "\"");
                } else {
                    return ResponseEntity.badRequest().body("\"Lottery tickets you want to sell back were not found\"");
                }
            } else {
                return ResponseEntity.badRequest().body("\"Lottery tickets you want to sell back were not found\"");
            }
        }else {
            return ResponseEntity.badRequest().body("\"UserId must contain 10 digits without spaces\"");
        }
    }
}

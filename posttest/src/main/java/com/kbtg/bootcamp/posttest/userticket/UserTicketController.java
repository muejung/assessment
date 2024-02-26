package com.kbtg.bootcamp.posttest.userticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kbtg.bootcamp.posttest.utils.numberValidation.isUserPattern;

@RestController
public class UserTicketController {

    @Autowired
    private UserTicketService userTicketService;

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<String> buyLottery(@PathVariable String userId, @PathVariable String ticketId) {
        return userTicketService.buyLottery(userId, ticketId);
    }

    @GetMapping("/users/{userId}/lotteries")
    public ResponseEntity<String> getLotteryByUserId(@PathVariable("userId") String userId) {
        List<String> userTicket = userTicketService.allTicketbyUser(userId);
        if(isUserPattern(userId)) {
            return ResponseEntity.ok().body("\"tickets\": " + userTicket);
        } else {
            return ResponseEntity.badRequest().body("\"UserId must contain 10 digits without spaces\"");
        }
    }

    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<String> deleteLotteryByUserId(@PathVariable String userId, @PathVariable String ticketId) {
        return userTicketService.deleteTicketbyUser(userId, ticketId);
    }
}
package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kbtg.bootcamp.posttest.utils.convertObjectToString.convertObjectToString;
import static com.kbtg.bootcamp.posttest.utils.numberValidation.isLotteryPattern;

@Service
public class LotteryService {
    @Autowired
    private LotteryRepository lotteryRepository;

        public List<String> allLotteryID() {
        List<Object[]> lotteries = lotteryRepository.getTicketID();
        return convertObjectToString(lotteries);
    }

    public ResponseEntity<String> addLottery(Lottery lottery) {
        if(isLotteryPattern(lottery.getTicket())){
            lotteryRepository.save(lottery);
            return ResponseEntity.ok("\"ticket\": \"" + lottery.getTicket() + "\"");
        } else {
            return ResponseEntity.badRequest().body("\"Lottery must contain 6 digits without spaces\"");
        }
    }
}


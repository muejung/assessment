package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LotteryController {
    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/lotteries")
    public ResponseEntity<String> getLottery() {
        return ResponseEntity.ok().body("\"tickets\": " + lotteryService.allLotteryID());
    }

    @PostMapping("/admin/lotteries")
    @PreAuthorize("hasAuthority('Admin_Create')")
    public ResponseEntity<String> addLottery(@RequestBody Lottery lottery) {
        return lotteryService.addLottery(lottery);
    }
}

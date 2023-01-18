package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Service
public class BootStrapService {

    @Autowired
    private ClaimRepository claimRepository;
    private String[] actionsLog1 = {"12/07/2022 - Claim Created", "12/19/2022 - Claim reviewed. Awaiting update from third party"};


    @PostConstruct
    public void setUpInitialData() {
        int numberOfClaims = claimRepository.findAll().size();
        if (numberOfClaims == 0) {
            Claim newClaim1 = new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", 0 , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", actionsLog1 );
//            Claim newClaim2 = new Claim("Younger", "Louise", Date.valueOf("2022-09-14"), "Motor", "Honda", "Prelude", 1999 , "", "", "", 400.00,"Reversed into a wall, damaged bumper", "", "Awaiting Assessment", "Pending");
            Claim newClaim3 = new Claim("Quinn", "Anne Marie", Date.valueOf("2022-08-11"), "Property", "", "", 0 , "16 Drum Road, Derry", "", "", 500.00,"Burnt the kitchen blinds making a pot noodle", "It was a Bombay Badboy flavoured one", "Awaiting Assessment", "Pending", actionsLog1);
//            Claim newClaim4 = new Claim("Temple", "Christopher", Date.valueOf("2022-11-20"), "Pet", "", "", 0 , "", "Dog", "Jack Russell", 250.00,"Dog hit by a car", "", "Awaiting Assessment", "Pending");

            Claim savedClaim1 = claimRepository.save(newClaim1);
//            Claim savedClaim2 = claimRepository.save(newClaim2);
            Claim savedClaim3 = claimRepository.save(newClaim3);
//            Claim savedClaim4 = claimRepository.save(newClaim4);
        }
    }


}

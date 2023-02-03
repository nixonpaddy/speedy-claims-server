package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ActionRepository;
import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class BootStrapService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ActionRepository actionRepository;


    @PostConstruct
    public void setUpInitialData() {
        int numberOfClaims = claimRepository.findAll().size();
        int numberOfActions = actionRepository.findAll().size();




        if(claimRepository.count() == 0){

            Action newAction1 = new Action("10/10/2022 - Claim Created", 1, Date.valueOf("2022-10-10"));
            Action newAction2 = new Action("12/14/2022 - Claim Created", 2, Date.valueOf("2022-12-14"));
            Action newAction3 = new Action("11/12/2022 - Claim Created", 3, Date.valueOf("2022-11-12"));
            Action newAction4 = new Action("01/01/2023 - Claim Created", 4, Date.valueOf("2023-01-01"));
            Action newAction5 = new Action("12/09/2022 - Claim Created", 5, Date.valueOf("2022-12-09"));
            Action newAction6 = new Action("12/19/2022 - Claim reviewed. Awaiting photographs of damage", 2, Date.valueOf("2022-12-19"));
            Action newAction7 = new Action("11/13/2022 - Claim reviewed. Awaiting photographs of damage", 3, Date.valueOf("2022-11-13"));
            Action newAction8 = new Action("12/28/2022 - Photographs received, forwarded to assessor for quote", 3, Date.valueOf("2022-12-28"));
            Action newAction9 = new Action("01/02/2023 - Quote of £500 received from assessor, passed to customer for review", 3, Date.valueOf("2023-01-02"));
            Action newAction10 = new Action("01/06/2023 - Quote accepted. Sent for funds to be released to customer", 3, Date.valueOf("2023-01-06"));
            Action newAction11 = new Action("02/02/2023 - Claim reviewed. Awaiting photographs of damage", 4, Date.valueOf("2023-02-02"));
            Action newAction12 = new Action("12/12/2022 - Claim reviewed. Awaiting vets report", 5, Date.valueOf("2022-12-12"));
            Action newAction13 = new Action("12/16/2022 - Vets report received. Leg not broken, only sprained. Claim rejected", 5, Date.valueOf("2022-12-16"));



            List<Action> actions = new ArrayList<>();
            List<Action> actions2 = new ArrayList<>();
            List<Action> actions3 = new ArrayList<>();
            List<Action> actions4 = new ArrayList<>();
            List<Action> actions5 = new ArrayList<>();


            actions.add(newAction1);
            actions2.add(newAction2);
            actions2.add(newAction6);
            actions3.add(newAction3);
            actions3.add(newAction7);
            actions3.add(newAction8);
            actions3.add(newAction9);
            actions3.add(newAction10);
            actions4.add(newAction4);
            actions4.add(newAction11);
            actions5.add(newAction5);
            actions5.add(newAction12);
            actions5.add(newAction13);


            Claim claim = new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", actions);
            Claim claim2 = new Claim("Younger", "Louise", Date.valueOf("2022-12-14"), "Motor", "Honda", "Prelude", 1999 , "", "", "", 400.00,"Reversed into a wall, damaged bumper", "", "In Progress", "Pending", actions2);
            Claim claim3 = new Claim("Quinn", "Anne Marie", Date.valueOf("2022-11-12"), "Property", "", "", null , "12 Up The Street, Galliagh, Derry", "", "", 500.00,"Windows at front of house smashed", "Criminal Damage. Incident has been reported to police", "Accepted - Awaiting Payment", "500.00", actions3);
            Claim claim4 = new Claim("Temple", "Chris", Date.valueOf("2023-01-01"), "Motor", "Nissan", "Juke", 2013 , "", "", "", 150.00,"Wing mirror clipped off", "", "In Progress", "Pending", actions4);
            Claim claim5 = new Claim("Williamson", "Mark", Date.valueOf("2022-12-09"), "Pet", "", "", null , "", "Dog", "Chihuahua", 300.00,"Vet Billsr", "Dog has broken leg", "Rejected", "0.00", actions5);

            claimRepository.save(claim);
            claimRepository.save(claim2);
            claimRepository.save(claim3);
            claimRepository.save(claim4);
            claimRepository.save(claim5);
        }


    }


}

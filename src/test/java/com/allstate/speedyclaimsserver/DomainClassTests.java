package com.allstate.speedyclaimsserver;

import com.allstate.speedyclaimsserver.domain.Claim;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DomainClassTests {

    @Test
    public void test2ClaimsWithTheSamePolicyNumberAreEqual(){
        Claim claim1 = new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null);
        Claim claim2 = new Claim("Younger", "Louise", Date.valueOf("2022-12-14"), "Motor", "Honda", "Prelude", 1999 , "", "", "", 400.00,"Reversed into a wall, damaged bumper", "", "In Progress", "Pending", null, null);
        Claim claim3 = new Claim("Quinn", "Anne Marie", Date.valueOf("2022-11-12"), "Property", "", "", null , "12 Up The Street, Galliagh, Derry", "", "", 500.00,"Windows at front of house smashed", "Criminal Damage. Incident has been reported to police", "Accepted - Awaiting Payment", "500.00", null, null);
        Claim claim4 = new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null);
        Claim claim5 = new Claim("Williamson", "Mark", Date.valueOf("2022-12-09"), "Pet", "", "", null , "", "Dog", "Chihuahua", 300.00,"Vet Billsr", "Dog has broken leg", "Rejected", "0.00", null, null);
        claim1.setPolicyNumber(59);
        claim4.setPolicyNumber(59);
        assertNotEquals(claim1, claim2);
        assertEquals(claim1, claim4);


    }
}

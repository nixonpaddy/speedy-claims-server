package com.allstate.speedyclaimsserver;

import com.allstate.speedyclaimsserver.data.ActionRepository;
import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.data.TaskRepository;
import com.allstate.speedyclaimsserver.domain.Claim;
import com.allstate.speedyclaimsserver.service.ClaimService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ClaimServiceTests {

    @Autowired
    private ClaimService claimService;

    @MockBean
    private ClaimRepository claimRepository;

    @MockBean
    private ActionRepository actionRepository;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testGetAllClaims(){
        List<Claim> claims = new ArrayList<>();

        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        Mockito.when(claimRepository.findAll()).thenReturn(claims);

        List<Claim> foundClaims = claimService.getAllClaims();
        assertEquals(6,foundClaims.size());

    }


    @Test
    public void testGetAllOpenClaims(){
        List<Claim> claims = new ArrayList<>();

        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf1", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "In Progress", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf2", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf3", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Accepted - Awaiting Payment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf4", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf5", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Rejected", "Pending", null, null));
        claims.add(new Claim("Nixon", "Paddy", Date.valueOf("2022-10-10"), "Pet", "", "", null , "", "Hamster", "Dwarf6", 250.00,"Expensive Hamster. Escaped out the back door", "Hamster imported from Timbucktoo", "Awaiting Assessment", "Pending", null, null));
        Mockito.when(claimRepository.findAll()).thenReturn(claims);

        List<Claim> foundClaims = claimService.getOpenClaims();
        assertEquals(5,foundClaims.size());

    }

}

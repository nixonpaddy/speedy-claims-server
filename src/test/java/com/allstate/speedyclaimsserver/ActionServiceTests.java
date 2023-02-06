package com.allstate.speedyclaimsserver;


import com.allstate.speedyclaimsserver.data.ActionRepository;
import com.allstate.speedyclaimsserver.data.ClaimRepository;
import com.allstate.speedyclaimsserver.domain.Action;
import com.allstate.speedyclaimsserver.service.ActionService;
import nonapi.io.github.classgraph.utils.Assert;
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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ActionServiceTests {



    @Autowired
    private ActionService actionService;

    @MockBean
    private ActionRepository actionRepository;

    @MockBean
    private ClaimRepository claimRepository;

    @Test
    public void testGetActionsByPolicy(){

        List<Action> actions = new ArrayList<>();
        actions.add(new Action("10/10/2022 - Claim Created", 1, Date.valueOf("2022-10-10")));
        actions.add(new Action("12/14/2022 - Claim Created", 2, Date.valueOf("2022-12-14")));
        actions.add(new Action("11/12/2022 - Claim Created", 3, Date.valueOf("2022-11-12")));
        actions.add(new Action("01/01/2023 - Claim Created", 4, Date.valueOf("2023-01-01")));
        actions.add(new Action("12/09/2022 - Claim Created", 5, Date.valueOf("2022-12-09")));
        actions.add(new Action("12/19/2022 - Claim reviewed. Awaiting photographs of damage", 2, Date.valueOf("2022-12-19")));
        actions.add(new Action("11/13/2022 - Claim reviewed. Awaiting photographs of damage", 3, Date.valueOf("2022-11-13")));
        actions.add(new Action("12/28/2022 - Photographs received, forwarded to assessor for quote", 3, Date.valueOf("2022-12-28")));
        actions.add(new Action("01/02/2023 - Quote of £500 received from assessor, passed to customer for review", 3, Date.valueOf("2023-01-02")));
        actions.add(new Action("01/06/2023 - Quote accepted. Sent for funds to be released to customer", 3, Date.valueOf("2023-01-06")));
        actions.add(new Action("02/02/2023 - Claim reviewed. Awaiting photographs of damage", 4, Date.valueOf("2023-02-02")));
        actions.add(new Action("12/12/2022 - Claim reviewed. Awaiting vets report", 5, Date.valueOf("2022-12-12")));
        actions.add(new Action("12/16/2022 - Vets report received. Leg not broken, only sprained. Claim rejected", 5, Date.valueOf("2022-12-16")));
        Mockito.when(actionRepository.findAll()).thenReturn(actions);

        List<Action> foundActions = actionService.getActionsByPolicy(3);
        assertEquals(5, foundActions.size());


    }


}

package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(value = DivesAPIController.class, secure = false)
public class DivesAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DivesService divesService;

    @MockBean
    private AuthenticationService authenticationService;

    private static final String INVALID_TOKEN = "invalid";
    private static final int VALID_USER_ID = 1;

    @Test
    public void whenGetAllDives_shouldReturnAllDives() throws Exception {
        Dive dive1 = new Dive();
        dive1.setLocation("Mexico");

        List<Dive> diveList = Arrays.asList(dive1);

        when(authenticationService.getUserIdFromToken("token")).thenReturn(VALID_USER_ID);
        when(divesService.getAllDives(VALID_USER_ID)).thenReturn(diveList);

//TODO: get this test working!
//        mvc.perform(get("/api/logbook/dives").param("token","test")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].location", is(dive1.getLocation())));
    }
    @Test
    public void whenGetAllDivesWithInvalidToken_shouldReturnThrowException() throws Exception {
        TokenInvalidException exception = new TokenInvalidException();

        doThrow(exception).when(authenticationService).validateToken(INVALID_TOKEN);

        mvc.perform(get("/api/logbook/dives").param("token", INVALID_TOKEN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(status().reason("Token Invalid Exception occurred"));

    }

    @Test
    public void whenSaveDive_shouldReturnDive() throws Exception{

        Dive dive = new Dive();
        dive.setLocation("Egypt");

        Dive diveFromRepo = new Dive();
        diveFromRepo.setLocation(dive.getLocation());

        when(authenticationService.getUserIdFromToken("token")).thenReturn(VALID_USER_ID);
        when(divesService.save(dive,VALID_USER_ID)).thenReturn(diveFromRepo);

        String result = new ObjectMapper().writeValueAsString(dive);
        System.out.println(result);

        mvc.perform(post("/api/logbook/dives")
                .contentType(MediaType.APPLICATION_JSON)
                .content(result)
                .param("token","token"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location", is(diveFromRepo.getLocation())));
    }
}
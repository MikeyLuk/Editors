package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DivesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)

@WebMvcTest(value = DivesAPIController.class, secure = false)
public class DivesAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DivesService divesService;

    @Test
    public void whenGetAllDives_shouldReturnAllDives() throws Exception {
        Dive dive1 = new Dive();
        dive1.setLocation("Mexico");

        List<Dive> diveList = Arrays.asList(dive1);

        when(divesService.getAllDives()).thenReturn(diveList);

        mvc.perform(get("/api/logbook/dives")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].location", is(dive1.getLocation())));
    }
}
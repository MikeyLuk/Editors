package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DiveRepository;
import com.andymitchell.divedb.logic.dives.DivesService;
import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DivesServiceTest {
    public static final int VALID_ID = 1;
    public static final int SECOND_VALID_ID = 2;
    public static final int THIRD_VALID_ID = 3;
    public static final int FOURTH_VALID_ID = 4;

    public static final int VALID_USER_ID = 1;

    public static final LocalDate VALID_DATE = LocalDate.of(2012, 1, 1);
    public static final String VALID_LOCATION = "Mexico";

    public static final int VALID_NO_OF_DIVES = 14;

    private Dive dive1;
    private Dive dive2;
    private Dive dive1FromRepo;
    private Dive dive2FromRepo;

    private DiveRepository diveRepositoryMock;
    private DivesService divesService;


    @Before
    public void setUp()  {
        dive1 = new Dive();
        dive1.setId(VALID_ID);

        dive2 = new Dive();
        dive2.setId(SECOND_VALID_ID);

        dive1FromRepo = new Dive();
        dive1FromRepo.setId(THIRD_VALID_ID);

        dive2FromRepo = new Dive();
        dive2FromRepo.setId(FOURTH_VALID_ID);

        diveRepositoryMock = Mockito.mock(DiveRepository.class);
        divesService = new DivesService(diveRepositoryMock);

    }

    @Test
    public void whenSavingDive_shouldCallRepositorySaveMethod() {
        when(diveRepositoryMock.save(dive1, VALID_USER_ID)).thenReturn(dive1FromRepo);

        Dive savedDive = divesService.save(dive1, VALID_USER_ID);

        verify(diveRepositoryMock).save(dive1, VALID_USER_ID);
        assertThat(savedDive).isEqualTo(dive1FromRepo);
    }

    @Test
    public void whenGettingAllDives_shouldReturnListOfDives() {
        when(diveRepositoryMock.getAllDives(VALID_USER_ID)).thenReturn(Arrays.asList(dive1,dive2));

        List<Dive> diveList = divesService.getAllDives(VALID_USER_ID);

        verify(diveRepositoryMock).getAllDives(VALID_USER_ID);
        assertThat(diveList).hasSize(2);
        assertThat(diveList).contains(dive1,dive2);
    }

    @Test
    public void whenGettingDiveFromId_shouldReturnDive() {
        when(diveRepositoryMock.getDiveFromId(VALID_ID, VALID_USER_ID)).thenReturn(dive1);

        Dive dive = divesService.getDiveFromId(VALID_ID,VALID_USER_ID);

        verify(diveRepositoryMock).getDiveFromId(VALID_ID, VALID_USER_ID);
        assertThat(dive).isEqualTo(dive1);
    }

    @Test
    public void whenGettingDivesFromDate_shouldReturnDiveList() {
        when(diveRepositoryMock.getDivesFromDate(VALID_DATE, VALID_USER_ID)).thenReturn(Arrays.asList(dive1,dive2));

        List<Dive> diveList = divesService.getDivesFromDate(VALID_DATE, VALID_USER_ID);

        verify(diveRepositoryMock).getDivesFromDate(VALID_DATE, VALID_USER_ID);
        assertThat(diveList).hasSize(2);
        assertThat(diveList).contains(dive1,dive2);
    }

    @Test
    public void whenGettingDivesFromLocation_shouldReturnDiveList() {
        when(diveRepositoryMock.getDivesFromLocation(VALID_LOCATION, VALID_USER_ID)).thenReturn(Arrays.asList(dive1,dive2));

        List<Dive> diveList = divesService.getDivesFromLocation(VALID_LOCATION, VALID_USER_ID);

        verify(diveRepositoryMock).getDivesFromLocation(VALID_LOCATION, VALID_USER_ID);
        assertThat(diveList).hasSize(2);
        assertThat(diveList).contains(dive1,dive2);
    }

    @Test
    public void whenGettingDivesFromDateAndLocation_shouldReturnDiveList() {
        when(diveRepositoryMock.getDivesFromDateAndLocation(VALID_DATE,VALID_LOCATION, VALID_USER_ID)).thenReturn(Arrays.asList(dive1,dive2));

        List<Dive> diveList = divesService.getDivesFromDateAndLocation(VALID_DATE,VALID_LOCATION, VALID_USER_ID);

        verify(diveRepositoryMock).getDivesFromDateAndLocation(VALID_DATE,VALID_LOCATION, VALID_USER_ID);
        assertThat(diveList).hasSize(2);
        assertThat(diveList).contains(dive1,dive2);
    }

    @Test
    public void whenDeletingAllDives_shouldReturnDiveList() {
        when(diveRepositoryMock.deleteAllDives(VALID_USER_ID)).thenReturn(Arrays.asList(dive1,dive2));

        List<Dive> diveList = divesService.deleteAllDives(VALID_USER_ID);

        verify(diveRepositoryMock).deleteAllDives(VALID_USER_ID);
        assertThat(diveList).hasSize(2);
        assertThat(diveList).contains(dive1,dive2);
    }

    @Test
    public void whenDeletingDiveById_shouldReturnDive() {
        when(diveRepositoryMock.deleteDiveFromId(VALID_ID, VALID_USER_ID)).thenReturn(dive1);

        Dive dive = divesService.deleteDiveFromId(VALID_ID, VALID_USER_ID);

        verify(diveRepositoryMock).deleteDiveFromId(VALID_ID,VALID_USER_ID);
        assertThat(dive).isEqualTo(dive1);
    }

    @Test
    public void whenGettingDiveById_shouldReturnDive() {
        when(diveRepositoryMock.getDiveFromId(VALID_ID, VALID_USER_ID)).thenReturn(dive1);

        Dive dive = divesService.getDiveFromId(VALID_ID, VALID_USER_ID);

        verify(diveRepositoryMock).getDiveFromId(VALID_ID, VALID_USER_ID);
        assertThat(dive).isEqualTo(dive1);
    }

    @Test
    public void whenUpdatingDiveById_shouldReturnDive() {
        when(diveRepositoryMock.updateDiveFromId(VALID_ID,dive1,VALID_USER_ID)).thenReturn(dive1FromRepo);

        Dive dive = divesService.updateDiveFromId(VALID_ID,dive1,VALID_USER_ID);

        verify(diveRepositoryMock).updateDiveFromId(VALID_ID,dive1,VALID_USER_ID);
        assertThat(dive).isEqualTo(dive1FromRepo);
    }

    @Test
    public void whenUpdatingMultipleDives_shouldReturnDiveList() {
        List<Dive> diveList = new ArrayList<>();
        diveList.add(dive1);
        diveList.add(dive2);
        when(diveRepositoryMock.updateMultipleDives(diveList,VALID_USER_ID)).thenReturn(Arrays.asList(dive1FromRepo,dive2FromRepo));

        List<Dive> outputList = divesService.updateMultipleDives(diveList,VALID_USER_ID);

        verify(diveRepositoryMock).updateMultipleDives(diveList,VALID_USER_ID);
        assertThat(outputList).contains(dive1FromRepo,dive2FromRepo);
    }

    @Test
    public void whenGettingDiveStatistic_shouldReturnStatistic() {
        DiveStatistic diveStatisticFromRepo = new DiveStatistic();
        diveStatisticFromRepo.setTotalAmountOfDives(VALID_NO_OF_DIVES);
        when(diveRepositoryMock.getDiveStatistic(VALID_USER_ID)).thenReturn(diveStatisticFromRepo);

        DiveStatistic diveStatistic = divesService.getDiveStatistic(VALID_USER_ID);

        verify(diveRepositoryMock).getDiveStatistic(VALID_USER_ID);
        assertThat(diveStatistic).isEqualTo(diveStatisticFromRepo);
    }
}
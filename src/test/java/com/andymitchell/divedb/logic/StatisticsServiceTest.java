package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.logic.dives.DivesService;
import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import com.andymitchell.divedb.logic.statistics.StatisticsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {
    private static final int VALID_NO_OF_DIVES = 10;

    private DivesService divesService;
    private StatisticsService statisticsService;

    private DiveStatistic diveStatistic;

    @Before
    public void setUp()  {
        divesService = Mockito.mock(DivesService.class);
        statisticsService = new StatisticsService(divesService);

        diveStatistic = new DiveStatistic();
        diveStatistic.setTotalAmountOfDives(VALID_NO_OF_DIVES);
    }

    @Test
    public void whenGettingDiveStatistic_shouldReturnDiveStatistic () {
        when(divesService.getDiveStatistic()).thenReturn(diveStatistic);

        DiveStatistic methodOutput = statisticsService.getDiveStatistic();

        verify(divesService).getDiveStatistic();
        assertThat(methodOutput).isEqualTo(diveStatistic);
    }

}
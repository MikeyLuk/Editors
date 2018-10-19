package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.logic.dives.DivesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {
    private DivesService divesService;
    private StatisticsService statisticsService;

    private static int VALID_DURATION = 14;
    private static int SECOND_VALID_DURATION = 21;
    private int SUM_OF_VALID_DURATIONS = VALID_DURATION + SECOND_VALID_DURATION;
    private static final List<Integer> VALID_DURATION_LIST = Arrays.asList(VALID_DURATION, SECOND_VALID_DURATION);

    private static double VALID_DEPTH = 15.6;
    private static double SECOND_VALID_DEPTH = 26.7;
    private static double SUM_OF_VALID_DEPTHS = VALID_DEPTH + SECOND_VALID_DEPTH;
    private static final List<Double> VALID_DEPTH_LIST = Arrays.asList(VALID_DEPTH, SECOND_VALID_DEPTH);


    @Before
    public void setUp() throws Exception {
        divesService = Mockito.mock(DivesService.class);
        statisticsService = new StatisticsService(divesService);
    }
//
//    @Test
//    public void whenGettingTotalTimeUnderwater_shouldReturnTotalTime(){
//
//        when(divesService.getListOfTimeUnderwaterInMinutes()).thenReturn(VALID_DURATION_LIST);
//
//        int totalTime = statisticsService.getTotalTimeUnderwaterInMinutes();
//
//        verify(divesService).getListOfTimeUnderwaterInMinutes();
//        assertThat(totalTime).isEqualTo(SUM_OF_VALID_DURATIONS);
//    }
//
//    @Test
//    public void whenGettingAverageDepth_shouldReturnAverageDepth(){
//
//        when(divesService.getListOfAllDepthsInMeters()).thenReturn(VALID_DEPTH_LIST);
//
//        Double averageDepthInMeters = statisticsService.getAverageDepthInMeters();
//
//        verify(divesService).getListOfAllDepthsInMeters();
//        assertThat(averageDepthInMeters).isEqualTo(SUM_OF_VALID_DEPTHS/(double)VALID_DEPTH_LIST.size());
//    }
//
//    @Test
//    public void whenGettingDeepestDepth_shouldReturnDeepestDepth(){
//
//        when(divesService.getListOfAllDepthsInMeters()).thenReturn(VALID_DEPTH_LIST);
//
//        Double deepestDepthInMeters = statisticsService.getDeepestDepthInMeters();
//
//        verify(divesService).getListOfAllDepthsInMeters();
//        assertThat(deepestDepthInMeters).isEqualTo(SECOND_VALID_DEPTH);
//    }
//
//    @Test
//    public void whenGettingShallowestDepth_shouldReturnShallowestDepth(){
//
//        when(divesService.getListOfAllDepthsInMeters()).thenReturn(VALID_DEPTH_LIST);
//
//        Double deepestDepthInMeters = statisticsService.getShallowestDepthInMeters();
//
//        verify(divesService).getListOfAllDepthsInMeters();
//        assertThat(deepestDepthInMeters).isEqualTo(VALID_DEPTH);
//    }
}
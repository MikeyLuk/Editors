package com.andymitchell.divedb.logic;

import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.statistics.StatisticUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.andymitchell.divedb.logic.statistics.StatisticUtils.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StatisticUtilsTest {

    private Dive dive1;
    private Dive dive2;
    private List<Dive> VALID_TIME_DEPTH_LIST;

    private static final int VALID_DURATION = 10;
    private static final int SECOND_VALID_DURATION = 12;
    private static final int SUM_OF_VALID_DURATIONS = VALID_DURATION + SECOND_VALID_DURATION;

    private static final double VALID_DEPTH = 15.6;
    private static final double SECOND_VALID_DEPTH = 16.4;
    private static final double SUM_OF_VALID_DEPTHS = VALID_DEPTH + SECOND_VALID_DEPTH;

    @Before
    public void setUp()  {
        dive1 = new Dive();
        dive1.setDurationInMinutes(VALID_DURATION);
        dive1.setMaxDepthInMeters(VALID_DEPTH);
        dive2 = new Dive();
        dive2.setDurationInMinutes(SECOND_VALID_DURATION);
        dive2.setMaxDepthInMeters(SECOND_VALID_DEPTH);

        VALID_TIME_DEPTH_LIST = Arrays.asList(dive1,dive2);
    }

    @Test
    public void whenGettingTotalTimeFromTimeDepthList_shouldReturnTotalTime(){

        int totalTime = getTotalTimeFromTimeDepthList(VALID_TIME_DEPTH_LIST);

        assertThat(totalTime).isEqualTo(SUM_OF_VALID_DURATIONS);
    }

    @Test
    public void whenGettingAverageDepth_shouldReturnAverageDepth(){

        Double averageDepthInMeters = getAverageDepthFromTimeDepthList(VALID_TIME_DEPTH_LIST);

        assertThat(averageDepthInMeters).isEqualTo(SUM_OF_VALID_DEPTHS/(double)VALID_TIME_DEPTH_LIST.size());
    }

    @Test
    public void whenGettingDeepestDepth_shouldReturnDeepestDepth(){

        Double deepestDepthInMeters = getDeepestDepthFromTimeDepthList(VALID_TIME_DEPTH_LIST);

        assertThat(deepestDepthInMeters).isEqualTo(SECOND_VALID_DEPTH);
    }

    @Test
    public void whenGettingShallowestDepth_shouldReturnShallowestDepth(){

        Double deepestDepthInMeters = getShallowestDepthFromTimeDepthList(VALID_TIME_DEPTH_LIST);

        assertThat(deepestDepthInMeters).isEqualTo(VALID_DEPTH);
    }
}
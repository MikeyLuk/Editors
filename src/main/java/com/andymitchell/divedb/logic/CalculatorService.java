package com.andymitchell.divedb.logic;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class CalculatorService {

    public String planDive(double firstDiveDepthMeters, int firstDiveLengthMinutes,
                           double secondDiveDepthMeters, int secondDiveLengthMinutes) {

        char diveLetterGroup = getDiveLetterGroup(firstDiveDepthMeters, firstDiveLengthMinutes);

        return Character.toString(diveLetterGroup);
    }

    private Character getDiveLetterGroup(double firstDiveDepthMeters, int firstDiveLengthMinutes) {
        Map<Double, Map<Integer, Character>> depthMap = createDepthMap();

        if (firstDiveDepthMeters > 40) {
            return null;
        }

        double depthKey = 12;

        for (Double key : depthMap.keySet()) {
            if (firstDiveDepthMeters <= key) {
                depthKey = key;
                break;
            }
        }

        Character groupLetter = null;

        for (Integer key : depthMap.get(depthKey).keySet()) {
            if (firstDiveLengthMinutes <= key) {
                groupLetter = depthMap.get(depthKey).get(key);
                break;
            }
        }

        return groupLetter;
    }



    private  Map<Double, Map<Integer, Character>> createDepthMap() {
        Map<Double, Map<Integer, Character>> depthMap = new LinkedHashMap<>();

        Map<Integer, Character> twelveMeterMap = new LinkedHashMap<>();

        twelveMeterMap.put(5, 'A');
        twelveMeterMap.put(15, 'B');
        twelveMeterMap.put(25, 'C');
        twelveMeterMap.put(30, 'D');
        twelveMeterMap.put(40, 'E');
        twelveMeterMap.put(50, 'F');
        twelveMeterMap.put(70, 'G');
        twelveMeterMap.put(80, 'H');
        twelveMeterMap.put(100, 'I');
        twelveMeterMap.put(110, 'J');
        twelveMeterMap.put(130, 'K');
        twelveMeterMap.put(150, 'L');

        Map<Integer, Character> fifteenMeterMap = new LinkedHashMap<>();

        fifteenMeterMap.put(10, 'B');
        fifteenMeterMap.put(15, 'C');
        fifteenMeterMap.put(25, 'D');
        fifteenMeterMap.put(30, 'E');
        fifteenMeterMap.put(40, 'F');
        fifteenMeterMap.put(50, 'G');
        fifteenMeterMap.put(60, 'H');
        fifteenMeterMap.put(70, 'I');
        fifteenMeterMap.put(80, 'J');
        fifteenMeterMap.put(100, 'L');

        Map<Integer, Character> eighteenMeterMap = new LinkedHashMap<>();

        eighteenMeterMap.put(10, 'B');
        eighteenMeterMap.put(15, 'C');
        eighteenMeterMap.put(20, 'D');
        eighteenMeterMap.put(25, 'E');
        eighteenMeterMap.put(30, 'F');
        eighteenMeterMap.put(40, 'G');
        eighteenMeterMap.put(50, 'H');
        eighteenMeterMap.put(55, 'I');
        eighteenMeterMap.put(60, 'J');
        eighteenMeterMap.put(80, 'L');

        Map<Integer, Character> twentyOneMeterMap = new LinkedHashMap<>();

        twentyOneMeterMap.put(5, 'B');
        twentyOneMeterMap.put(10, 'C');
        twentyOneMeterMap.put(15, 'D');
        twentyOneMeterMap.put(20, 'E');
        twentyOneMeterMap.put(30, 'F');
        twentyOneMeterMap.put(35, 'G');
        twentyOneMeterMap.put(40, 'H');
        twentyOneMeterMap.put(45, 'I');
        twentyOneMeterMap.put(50, 'J');
        twentyOneMeterMap.put(60, 'K');
        twentyOneMeterMap.put(70, 'L');

        Map<Integer, Character> twentyFourMeterMap = new LinkedHashMap<>();

        twentyFourMeterMap.put(5, 'B');
        twentyFourMeterMap.put(10, 'C');
        twentyFourMeterMap.put(15, 'D');
        twentyFourMeterMap.put(20, 'E');
        twentyFourMeterMap.put(25, 'F');
        twentyFourMeterMap.put(30, 'G');
        twentyFourMeterMap.put(35, 'H');
        twentyFourMeterMap.put(40, 'I');
        twentyFourMeterMap.put(50, 'K');
        twentyFourMeterMap.put(60, 'L');

        Map<Integer, Character> twentySevenMeterMap = new LinkedHashMap<>();

        twentySevenMeterMap.put(5, 'B');
        twentySevenMeterMap.put(10, 'C');
        twentySevenMeterMap.put(12, 'D');
        twentySevenMeterMap.put(15, 'E');
        twentySevenMeterMap.put(20, 'F');
        twentySevenMeterMap.put(25, 'G');
        twentySevenMeterMap.put(30, 'H');
        twentySevenMeterMap.put(40, 'J');
        twentySevenMeterMap.put(50, 'L');


        Map<Integer, Character> thirtyMeterMap = new LinkedHashMap<>();

        thirtyMeterMap.put(5, 'B');
        thirtyMeterMap.put(7, 'C');
        thirtyMeterMap.put(10, 'D');
        thirtyMeterMap.put(15, 'E');
        thirtyMeterMap.put(20, 'F');
        thirtyMeterMap.put(22, 'G');
        thirtyMeterMap.put(25, 'H');
        thirtyMeterMap.put(40, 'K');

        Map<Integer, Character> thirtyThreeMeterMap = new LinkedHashMap<>();

        thirtyThreeMeterMap.put(5, 'C');
        thirtyThreeMeterMap.put(10, 'D');
        thirtyThreeMeterMap.put(13, 'E');
        thirtyThreeMeterMap.put(15, 'F');
        thirtyThreeMeterMap.put(20, 'G');
        thirtyThreeMeterMap.put(30, 'J');

        Map<Integer, Character> thirtySixMeterMap = new LinkedHashMap<>();

        thirtySixMeterMap.put(5, 'C');
        thirtySixMeterMap.put(10, 'D');
        thirtySixMeterMap.put(12, 'E');
        thirtySixMeterMap.put(15, 'F');
        thirtySixMeterMap.put(25, 'I');
        thirtySixMeterMap.put(30, 'J');

        Map<Integer, Character> fortyMeterMap = new LinkedHashMap<>();

        fortyMeterMap.put(5, 'C');
        fortyMeterMap.put(8, 'D');
        fortyMeterMap.put(10, 'E');
        fortyMeterMap.put(25, 'J');

        depthMap.put((double) 12, twelveMeterMap);
        depthMap.put((double) 15, fifteenMeterMap);
        depthMap.put((double) 18, eighteenMeterMap);
        depthMap.put((double) 21, twentyOneMeterMap);
        depthMap.put((double) 24, twentyFourMeterMap);
        depthMap.put((double) 27, twentySevenMeterMap);
        depthMap.put((double) 30, thirtyMeterMap);
        depthMap.put((double) 33, thirtyThreeMeterMap);
        depthMap.put((double) 36, thirtySixMeterMap);
        depthMap.put((double) 40, fortyMeterMap);
        return depthMap;
    }


}

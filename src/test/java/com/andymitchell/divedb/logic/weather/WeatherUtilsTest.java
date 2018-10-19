package com.andymitchell.divedb.logic.weather;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class WeatherUtilsTest {
    private WeatherUtils weatherUtils;
    private static final double VALID_KELVIN_VALUE = 237;
    private static final double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
    private static final String LOWER_CASE_STRING = "hello world";
    private static final String CAPITALISED_STRING = "Hello world";
    private static final double UNROUNDED_VALUE = 2.36789;
    private static final double VALUE_ROUNDED_TO_TWO_DP = 2.37;


    @Before
    public void setUp() throws Exception {
        weatherUtils = new WeatherUtils();
    }

    @Test
    public void whenConvertingKelvinToCelsius_shouldReturnConversion() {
        Double convertionResult = weatherUtils.convertKelvinToCelsius(VALID_KELVIN_VALUE);

        assertThat(convertionResult).isEqualTo(VALID_KELVIN_VALUE + ABSOLUTE_ZERO_IN_CELSIUS);
    }

    @Test
    public void whenConvertingNullToCelsius_shouldReturnNull() {
        Double convertionResult = weatherUtils.convertKelvinToCelsius(null);

        assertThat(convertionResult).isEqualTo(null);
    }

    @Test
    public void whenCallingCapitaliseFirstLetter_shouldReturnCapitalisedString() {

        String methodOutput = weatherUtils.capitaliseFirstLetter(LOWER_CASE_STRING);

        assertThat(methodOutput).isEqualTo(CAPITALISED_STRING);
    }

    @Test
    public void whenCapitalisingNull_shouldReturnNull() {

        String methodOutput = weatherUtils.capitaliseFirstLetter(null);

        assertThat(methodOutput).isEqualTo(null);
    }

    @Test
    public void whenCapitalisinASAgNull_shouldReturnNull() {

        String methodOutput = weatherUtils.capitaliseFirstLetter("t");

        assertThat(methodOutput).isEqualTo("T");
    }

    @Test
    public void whenRoundingToTwoDP_shouldReturnRoundedNumber() {
        Double methodOutput = weatherUtils.roundToTwoDP(UNROUNDED_VALUE);

        assertThat(methodOutput).isEqualTo(VALUE_ROUNDED_TO_TWO_DP);
    }

    @Test
    public void whenRoundingANullValue_shouldReturnNull(){
        Double methodOutput = weatherUtils.roundToTwoDP(null);

        assertThat(methodOutput).isEqualTo(null);
    }

    @Test
    public void whenRoundingAnIntToTwoDP_shouldReturnRoundedNumber() {
        Double methodOutput = weatherUtils.roundToTwoDP((double)20);

        assertThat(methodOutput).isEqualTo(20.00);
    }

}
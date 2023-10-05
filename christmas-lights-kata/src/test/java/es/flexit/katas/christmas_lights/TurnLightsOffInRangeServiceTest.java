package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnLightsOffInRangeServiceTest {

    private TurnLightsOffInRangeService tested;

    @BeforeEach
    void init() {
        this.tested = new TurnLightsOffInRangeService();
    }

    @Test
    void should_start_with_all_lights_turned_off() {
        // when
        var lightsGrid = new LightsGrid();

        // then
        assertThat(lightsGrid.countLightsOn()).isZero();
    }

    @Test
    void should_decrease_brightness_in_range_by_one_given_some_lights_are_turned_on() {
        // given
        var lightsGrid = new LightsGrid();
        var turnLightsOnInRangeService = new TurnLightsOnInRangeService();
        turnLightsOnInRangeService.turnLightsOn(lightsGrid, 498, 498, 500, 500);

        // when
        tested.turnLightsOff(lightsGrid, 499, 499, 500, 500);

        // then
        assertThat(lightsGrid.countLightsOn()).isEqualTo(5);
    }

    @Test
    void should_decrease_brightness_in_range_by_one_at_minimum_of_zero_if_they_are_turned_off() {
        // given
        var lightsGrid = new LightsGrid();

        // when
        tested.turnLightsOff(lightsGrid, 499, 499, 500, 500);

        // then
        assertThat(lightsGrid.countLightsOn()).isZero();
    }
}
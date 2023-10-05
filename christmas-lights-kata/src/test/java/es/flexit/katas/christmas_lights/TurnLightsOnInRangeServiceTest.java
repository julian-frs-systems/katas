package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnLightsOnInRangeServiceTest {

    private TurnLightsOnInRangeService tested;

    @BeforeEach
    void init() {
        this.tested = new TurnLightsOnInRangeService();
    }

    @Test
    void should_start_with_all_lights_turned_off() {
        // when
        var lightsGrid = new LightsGrid();

        // then
        assertThat(lightsGrid.countLightsOn()).isZero();
    }

    @Test
    void should_increase_brightness_in_range_by_one_given_some_lights_are_turned_off() {
        // given
        var lightsGrid = new LightsGrid();

        // when
        tested.turnLightsOn(lightsGrid, 0, 0, 0, 0);

        // then
        assertThat(lightsGrid.countLightsOn()).isEqualTo(1);
    }

    @Test
    void should_increase_brightness_in_range_by_one_if_they_are_turned_on() {
        // given
        var lightsGrid = new LightsGrid();
        tested.turnLightsOn(lightsGrid, 0, 0, 999, 999);

        // when
        tested.turnLightsOn(lightsGrid, 499, 499, 500, 500);

        // then
        assertThat(lightsGrid.countLightsOn()).isEqualTo(1000004);
    }
}
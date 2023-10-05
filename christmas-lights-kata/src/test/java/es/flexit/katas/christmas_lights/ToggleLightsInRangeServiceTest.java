package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToggleLightsInRangeServiceTest {

    private ToggleLightsInRangeService tested;

    @BeforeEach
    void init() {
        this.tested = new ToggleLightsInRangeService();
    }

    @Test
    void should_start_with_all_lights_turned_off() {
        // when
        var lightsGrid = new LightsGrid();

        // then
        assertThat(lightsGrid.countLightsOn()).isZero();
    }

    @Test
    void should_toggle_lights_in_range() {
        // given
        var lightsGrid = new LightsGrid();

        // when
        tested.toggleLights(lightsGrid, 0, 0, 999, 0);

        // then
        assertThat(lightsGrid.countLightsOn()).isEqualTo(2000);
    }
}
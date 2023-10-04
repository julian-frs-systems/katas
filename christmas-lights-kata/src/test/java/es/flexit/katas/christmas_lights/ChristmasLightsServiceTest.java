package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ChristmasLightsServiceTest {

    private LightsGrid lightsGrid;
    private ChristmasLightsService tested;

    @BeforeEach
    void init() {
        this.lightsGrid = new LightsGrid();
        this.tested = new ChristmasLightsService(this.lightsGrid);
    }

    @Test
    void should_start_with_all_lights_turned_off() {
        // when
        int result = lightsGrid.countLightsOn();

        // then
        assertThat(result).isZero();
    }

    // TODO Testear rangos dentro de los límites de la matriz.

    @Nested
    class TurnLightsOn {

        @Test
        void should_turn_on_all_lights_in_range_given_some_lights_are_turned_off() {
            // when
            tested.turnLightsOnInRange(0, 0, 999, 999);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(1000000);
        }

        @Test
        void should_keep_lights_turned_on_if_they_are_turned_on() {
            // given
            tested.turnLightsOnInRange(0, 0, 999, 999);

            // when
            tested.turnLightsOnInRange(499, 499, 500, 500);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(1000000);
        }
    }

    @Nested
    class ToggleLights {

        @Test
        void should_toggle_lights_in_range() {
            // when
            tested.toggleLightsInRange(0, 0, 999, 0);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(1000);
        }
    }

    @Nested
    class TurnLightsOff {

        @Test
        void should_turn_lights_off_in_range_given_some_lights_are_turned_on() {
            // given
            tested.turnLightsOnInRange(498, 498, 500, 500);

            // when
            tested.turnLightsOffInRange(499, 499, 500, 500);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(5);
        }

        @Test
        void should_keep_lights_turned_off_if_they_are_turned_off() {
            // when
            tested.turnLightsOffInRange(499, 499, 500, 500);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isZero();
        }
    }

    @Nested
    class Instructions {

        @Test
        void run_instructions_set() {
            // when
            tested.turnLightsOnInRange(887, 9, 959, 629);
            tested.turnLightsOnInRange(454, 398, 844, 448);
            tested.turnLightsOffInRange(539, 243, 559, 965);
            tested.turnLightsOffInRange(370, 819, 676, 868);
            tested.turnLightsOffInRange(145, 40, 370, 997);
            tested.turnLightsOffInRange(301, 3, 808, 453);
            tested.turnLightsOnInRange(351, 678, 951, 908);
            tested.toggleLightsInRange(720, 196, 897, 994);
            tested.toggleLightsInRange(831, 394, 904, 860);

            // then
            assertThat(lightsGrid.countLightsOn()).isEqualTo(230022);
        }
    }
}

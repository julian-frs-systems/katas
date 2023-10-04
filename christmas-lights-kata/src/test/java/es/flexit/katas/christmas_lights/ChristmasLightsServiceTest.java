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
            // given
            var coordinates1 = new Coordinates(0, 0);
            var coordinates2 = new Coordinates(999, 999);

            // when
            tested.turnLightsOnInRange(coordinates1, coordinates2);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(1000000);
        }

        @Test
        void should_keep_lights_turned_on_if_they_are_turned_on() {
            // given
            var coordinates1 = new Coordinates(0, 0);
            var coordinates2 = new Coordinates(999, 999);
            tested.turnLightsOnInRange(coordinates1, coordinates2);

            var givenCoordinates1 = new Coordinates(499, 499);
            var givenCoordinates2 = new Coordinates(500, 500);

            // when
            tested.turnLightsOnInRange(givenCoordinates1, givenCoordinates2);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(1000000);
        }
    }

    @Nested
    class ToggleLights {

        @Test
        void should_toggle_lights_in_range() {
            // given
            var coordinates1 = new Coordinates(0, 0);
            var coordinates2 = new Coordinates(999, 0);

            // when
            tested.toggleLightsInRange(coordinates1, coordinates2);
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
            var coordinates1 = new Coordinates(498, 498);
            var coordinates2 = new Coordinates(500, 500);
            tested.turnLightsOnInRange(coordinates1, coordinates2);

            var givenCoordinates1 = new Coordinates(499, 499);
            var givenCoordinates2 = new Coordinates(500, 500);

            // when
            tested.turnLightsOffInRange(givenCoordinates1, givenCoordinates2);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isEqualTo(5);
        }

        @Test
        void should_keep_lights_turned_off_if_they_are_turned_off() {
            // given
            var coordinates1 = new Coordinates(499, 499);
            var coordinates2 = new Coordinates(500, 500);

            // when
            tested.turnLightsOffInRange(coordinates1, coordinates2);
            int result = lightsGrid.countLightsOn();

            // then
            assertThat(result).isZero();
        }
    }
}

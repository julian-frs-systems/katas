package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ChristmasLightsServiceTest {

    @Nested
    class TurnLightsOnUseCases {

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
        void should_turn_on_all_lights_in_range_given_some_lights_are_turned_off() {
            // given
            var lightsGrid = new LightsGrid();

            // when
            tested.turnLightsOn(lightsGrid, 0, 0, 0, 0);

            // then
            assertThat(lightsGrid.countLightsOn()).isEqualTo(1);
        }

        @Test
        void should_keep_lights_turned_on_if_they_are_turned_on() {
            // given
            var lightsGrid = new LightsGrid();
            tested.turnLightsOn(lightsGrid, 0, 0, 999, 999);

            // when
            tested.turnLightsOn(lightsGrid, 499, 499, 500, 500);

            // then
            assertThat(lightsGrid.countLightsOn()).isEqualTo(1000004);
        }
    }

    @Nested
    class ToggleLightsUseCases {

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

    @Nested
    class TurnLightsOffUseCases {

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
        void should_turn_lights_off_in_range_given_some_lights_are_turned_on() {
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
        void should_keep_lights_turned_off_if_they_are_turned_off() {
            // given
            var lightsGrid = new LightsGrid();

            // when
            tested.turnLightsOff(lightsGrid, 499, 499, 500, 500);

            // then
            assertThat(lightsGrid.countLightsOn()).isZero();
        }
    }

    @Nested
    class InstructionsUseCases {

        private TurnLightsOnInRangeService turnLightsOnInRangeService;
        private ToggleLightsInRangeService toggleLightsInRangeService;
        private TurnLightsOffInRangeService turnLightsOffInRangeService;

        @BeforeEach
        void init() {
            this.turnLightsOnInRangeService = new TurnLightsOnInRangeService();
            this.toggleLightsInRangeService = new ToggleLightsInRangeService();
            this.turnLightsOffInRangeService = new TurnLightsOffInRangeService();
        }

        @Test
        void run_instructions_set() {
            // given
            var lightsGrid = new LightsGrid();

            // when
            turnLightsOnInRangeService.turnLightsOn(lightsGrid, 887, 9, 959, 629);
            turnLightsOnInRangeService.turnLightsOn(lightsGrid, 454, 398, 844, 448);
            turnLightsOffInRangeService.turnLightsOff(lightsGrid, 539, 243, 559, 965);
            turnLightsOffInRangeService.turnLightsOff(lightsGrid, 370, 819, 676, 868);
            turnLightsOffInRangeService.turnLightsOff(lightsGrid, 145, 40, 370, 997);
            turnLightsOffInRangeService.turnLightsOff(lightsGrid, 301, 3, 808, 453);
            turnLightsOnInRangeService.turnLightsOn(lightsGrid, 351, 678, 951, 908);
            toggleLightsInRangeService.toggleLights(lightsGrid, 720, 196, 897, 994);
            toggleLightsInRangeService.toggleLights(lightsGrid, 831, 394, 904, 860);

            // then
            assertThat(lightsGrid.countLightsOn()).isEqualTo(539560);
        }
    }
}

package es.flexit.katas.christmas_lights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasLightsContestTest {

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

package es.flexit.katas.christmas_lights;

public class ChristmasLightsService {

    private final LightsGrid lightsGrid;

    // LightsGrid could be passed in as parameter of every method
    public ChristmasLightsService(LightsGrid lightsGrid) {
        this.lightsGrid = lightsGrid;
    }

    public void turnLightsOnInRange(Coordinates coordinates1, Coordinates coordinates2) {
        for (int i = coordinates1.x; i <= coordinates2.x; i++) {
            for (int j = coordinates1.y; j <= coordinates2.y; j++) {
                this.lightsGrid.turnLightOn(i, j);
            }
        }
    }

    public void toggleLightsInRange(Coordinates coordinates1, Coordinates coordinates2) {
        for (int i = coordinates1.x; i <= coordinates2.x; i++) {
            for (int j = coordinates1.y; j <= coordinates2.y; j++) {
                this.lightsGrid.toggleLight(i, j);
            }
        }
    }

    public void turnLightsOffInRange(Coordinates coordinates1, Coordinates coordinates2) {
        for (int i = coordinates1.x; i <= coordinates2.x; i++) {
            for (int j = coordinates1.y; j <= coordinates2.y; j++) {
                this.lightsGrid.turnLightOff(i, j);
            }
        }
    }
}

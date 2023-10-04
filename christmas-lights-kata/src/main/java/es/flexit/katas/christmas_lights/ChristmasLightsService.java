package es.flexit.katas.christmas_lights;

public class ChristmasLightsService {

    private final LightsGrid lightsGrid;

    // LightsGrid could be passed in as parameter of every method
    public ChristmasLightsService(LightsGrid lightsGrid) {
        this.lightsGrid = lightsGrid;
    }

    public void turnLightsOnInRange(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                this.lightsGrid.turnLightOn(i, j);
            }
        }
    }

    public void toggleLightsInRange(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                this.lightsGrid.toggleLight(i, j);
            }
        }
    }

    public void turnLightsOffInRange(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                this.lightsGrid.turnLightOff(i, j);
            }
        }
    }
}

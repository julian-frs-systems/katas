package es.flexit.katas.christmas_lights;

public class ToggleLightsInRangeService {

    public void toggleLights(LightsGrid lightsGrid, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                lightsGrid.toggleLight(i, j);
            }
        }
    }
}

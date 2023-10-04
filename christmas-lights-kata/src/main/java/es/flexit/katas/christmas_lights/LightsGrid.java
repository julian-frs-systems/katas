package es.flexit.katas.christmas_lights;

public class LightsGrid {

    private static final int TOGGLE_BRIGHTNESS_AMOUNT = 2;
    private static final int MINIMUM_BRIGHTNESS_ALLOWED = 0;
    private static final int TURN_LIGHT_ON_BRIGHTNESS_AMOUNT = 1;
    private static final int TURN_LIGHT_OFF_BRIGHTNESS_AMOUNT = 1;
    private static final int X_SIZE = 1000;
    private static final int Y_SIZE = 1000;

    // Hiding the data structure in the "entity" helps with abstraction and de-coupling
    private final int[][] grid = new int[X_SIZE][Y_SIZE];

    public int countLightsOn() {
        int sum = 0;

        for (int i = 0; i < X_SIZE; i++) {
            for (int j = 0; j < Y_SIZE; j++) {
                sum += this.grid[i][j];
            }
        }

        return sum;
    }

    public void turnLightOn(int x, int y) {
        this.grid[x][y] += TURN_LIGHT_ON_BRIGHTNESS_AMOUNT;
    }

    public void toggleLight(int x, int y) {
        this.grid[x][y] += TOGGLE_BRIGHTNESS_AMOUNT;
    }

    public void turnLightOff(int x, int y) {
        if (this.grid[x][y] > MINIMUM_BRIGHTNESS_ALLOWED) {
            this.grid[x][y] -= TURN_LIGHT_OFF_BRIGHTNESS_AMOUNT;
        }
    }
}

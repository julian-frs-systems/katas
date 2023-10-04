package es.flexit.katas.christmas_lights;

public class LightsGrid {

    private static final int X_SIZE = 1000;
    private static final int Y_SIZE = 1000;

    // Hiding the data structure in the "entity" helps with abstraction and de-coupling
    private final boolean[][] grid = new boolean[X_SIZE][Y_SIZE];

    public int countLightsOn() {
        int counter = 0;

        for (int i = 0; i < X_SIZE; i++) {
            for (int j = 0; j < Y_SIZE; j++) {
                if (this.grid[i][j]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public void turnLightOn(int x, int y) {
        this.grid[x][y] = true;
    }

    public void toggleLight(int x, int y) {
        this.grid[x][y] = !this.grid[x][y];
    }

    public void turnLightOff(int x, int y) {
        this.grid[x][y] = false;
    }
}

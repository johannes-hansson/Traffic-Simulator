public class RoadPosition {
    private Road road;
    private int cell;
    private int lane;

    public RoadPosition(Road road, int cell, int lane) {
        this.road = road;
        this.cell = cell;
        this.lane = lane;
    }

    public Road getRoad() {
        return this.road;
    }

    public int getCell() {
        return this.cell;
    }

    public int getLane() {
        return this.lane;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }
}

public enum LaneChangeDecision {
    LEFT(1),
    RIGHT(-1),
    STRAIGHT(0);

    private int direction;

    private LaneChangeDecision(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }
}
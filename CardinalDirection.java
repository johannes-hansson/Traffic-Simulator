public enum CardinalDirection {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int intDirection;

    private CardinalDirection(int intDirection) {
        this.intDirection = intDirection;
    }

    public int getIntDirection() {
        return this.intDirection;
    }
}

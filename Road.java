public class Road {

    private int laneCount;
    private int length;

    public Road(int length, int laneCount) {
        this.length = length;
        this.laneCount = laneCount;
    }

    public int getLength() {
        return this.length;
    };

    public int getLanes() {
        return this.laneCount;
    };
}

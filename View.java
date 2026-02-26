import java.util.ArrayList;

public class View implements SimulationUpdateListener {

    @Override
    public void onUpdate(Simulation simulation) {
        // Hämta kartan för simulationen
        Map map = simulation.getMap();

        // Hämta alla vägar från kartan
        ArrayList<Road> roads = map.getRoads();

        // Gå igenom alla vägar
        for (Road road : roads) {
            // Road kommer har en metod getRoadRender() som returnerar
            // en RoadRender

            // RoadRender render = road.getRoadRender()

            // RoadRender har en metod getWidth() som returnerar
            // vägens bredd

            // double width = render.getWidth()

            // Road renedr har en metod getBreakPoints() som returnerar
            // en ArrayList med BreakPoint
            // BreakPoint är en klass som innehåller information om vilka
            // punkter en väg ska ritas mellan
            // BreakPoint har en metod getPosition() som returnerar dess koordinat
            // Breakpoint har en metod getCell() som returnerar vilken cell på vägen
            // den gäller för

            // ArrayList<BreakPoint> breakPoints = render.getBreakPoints()
            // for (int i = 0; i < breakPoints.length - 1; i++) {
                // Här kan man rita ett streck från en breakpoint till nästa breakpoint
                // BreakPoint currentPoint = breakPoints.get(i);
                // BreakPoint nextBreakPoint = breakPoints.get(i + 1);

                // Nu kan ett streck (vägen) ritas mellan currentPoint.getPosition() och nextBreakPoint.getPosition()
                // med bredden width
            //}
            
        }
    }
}

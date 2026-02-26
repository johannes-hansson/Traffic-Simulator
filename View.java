import java.util.ArrayList;

public class View implements SimulationUpdateListener {

    @Override
    public void onUpdate(Simulation simulation) {
        // Hämta kartan för simulationen
        Map map = simulation.getMap();

        // Hämta alla vägar från kartan
        ArrayList<Road> roads = map.getRoads();

        // Ett exempel på hur vägar kan ritas med hjälp av en
        // RoadRender komponent som har lagts till till Road
        for (Road road : roads) {
            // Road har en metod getRoadRender() som returnerar
            // en RoadRender

            RoadRender render = road.getRoadRender();

            // RoadRender har en metod getWidth() som returnerar
            // vägens bredd

            double width = render.getWidth();

            // Road render har en metod getBreakPoints() som returnerar
            // en ArrayList med BreakPoint
            // BreakPoint är en klass som innehåller information om vilka
            // punkter en väg ska ritas mellan
            // BreakPoint har en metod x() som returnerar dess x-koordinat
            // BreakPoint har en metod y() som returnerar dess y-koordinat
            // Breakpoint har en metod cell() som returnerar vilken cell på vägen
            // den gäller för

            ArrayList<BreakPoint> breakPoints = render.getBreakPoints();

            // RoadRender har även en metod displayPoints för att skriva ut alla breakPoints
            // render.displayPoints();

            // Gå sedan igenom alla punkter förrutom den sista
            // Rita ett streck från punkt i till punkt i+1 med bredd width
            for (int i = 0; i < breakPoints.size() - 1; i++) {

                BreakPoint currentPoint = breakPoints.get(i);
                BreakPoint nextPoint = breakPoints.get(i + 1);

                // Nu kan ett streck (vägen) ritas mellan currentPoint.x(), currentPoint.y()
                // och nextPoint.x(), nextPoint.y() med bredden width

                double xStart = currentPoint.x();
                double yStart = currentPoint.y();
                double xEnd = nextPoint.x();
                double yEnd = nextPoint.y();

                // drawLine(xStart, yStart, xEnd, yEnd, width);
            }
        }
    }
}

import Pathfinder.GenerationException;

public class Main {

    ProfileGenerator profGen;

    public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.profGen = new ProfileGenerator();
        mainObj.profGen.resetValues("INCHES");
        int[] xRange = {0, 40};
        int[] yRange = {-40, 40};

        for (int x = xRange[0]; x <= xRange[1]; x++) {
            for (int y = yRange[0]; y <= yRange[1]; y++) {
                mainObj.profGen.clearPoints();
                mainObj.profGen.addPoint(x, y, Math.atan(y/(x+0.001)));
                try {
                    mainObj.profGen.updateTrajectories();
                } catch (GenerationException e) {
                    System.out.println("GenExecp");
                }
                System.out.println(x + "x" + y);
            }
        }
    }
}
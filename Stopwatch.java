/*

Stopwatch

*/
public class Stopwatch {
    StopwatchFrame stopwatchFrame;
    ImageLabel imageLabel;
    CountLabel countLabel;
    ControlPanel controlPanel;
    ManualPanel manualPanel;
    CountController countController;
   

    public Stopwatch() {

        imageLabel = new ImageLabel();
        countLabel = new CountLabel();
        countController = new CountController(countLabel);
        controlPanel = new ControlPanel(countController);
        manualPanel = new ManualPanel();
        stopwatchFrame = new StopwatchFrame(imageLabel, countLabel, controlPanel, manualPanel);
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
    }
}
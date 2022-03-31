import javax.swing.*;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        //...TODO

        //invoke the layout manager
        pack();
    }

}

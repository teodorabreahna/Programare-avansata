import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner spinner;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    int rows, cols;
    //...
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button
        //...TODO
        add(label); //JPanel uses FlowLayout by default
        add(spinner);
    }

}

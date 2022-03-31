import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton createBtn = new JButton("Create");
    //create all buttons (Load, Exit, etc.)
    //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        exitBtn.setBounds(310,360,80,30);
        loadBtn.setBounds(220,360,80,30);
        saveBtn.setBounds(130,360,80,30);
        createBtn.setBounds(220,10,80,30);
        frame.add(exitBtn);
        frame.add(saveBtn);
        frame.add(loadBtn);
        frame.add(createBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::exitGame);
        createBtn.addActionListener(this::exitGame);
        //...TODO
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    //...TODO
}
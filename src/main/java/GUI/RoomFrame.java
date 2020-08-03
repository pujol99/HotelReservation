package GUI;

import Classes.*;
import Utils.*;

import javax.swing.*;

public class RoomFrame extends JFrame {

    private JPanel mainPanel;

    public RoomFrame(String title, Hotel hotel){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }
}

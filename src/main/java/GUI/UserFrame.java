package GUI;

import Classes.*;
import Utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JButton registerButton;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel directionLabel;
    private JTextField directionField;
    private JLabel emailLabel;
    private JTextField emailField;

    public UserFrame(String title, Hotel hotel){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactInfo contactInfo = new ContactInfo(
                        phoneField.getText(),
                        nameField.getText(),
                        directionField.getText(),
                        "",
                        emailField.getText());

                Client c = new Client(0, true);
                c.setContactInfo(contactInfo);
                hotel.addClient(c);

                for(Client client : hotel.getClients()){
                    Utils.printnl(client.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        Hotel myHotel = new Hotel(10);

        JFrame frame = new UserFrame("Hotel reservation", myHotel);
        frame.setSize(800, 600);
        frame.setVisible(true);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

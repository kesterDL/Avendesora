package Interface;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    JFrame frame = new JFrame();
    JLabel resultLabel;
    double balance;
    JButton button;
    static final double INTEREST_RATE = 5;
    static final double INITIAL_BALANCE = 1000;
    private ArrayList<Integer> stats = new ArrayList<>();

    public GUI() {
        balance = INITIAL_BALANCE;
        createGUI();
    }

    public void createGUI() {

        button = new JButton("Add Interest");
        ActionListener listener = new addInterestListener();
        button.addActionListener(listener);
        resultLabel = new JLabel("Balance: " + balance);

        JPanel panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
        panel_1.add(button);
        panel_1.add(resultLabel);
        frame.add(panel_1);

        frame.setSize(500, 100);
        frame.setTitle("Adding Interest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    class addInterestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            double interest = balance * INTEREST_RATE / 100;
            balance += interest;
            resultLabel.setText("Balance: " + balance);
        }
    }

}

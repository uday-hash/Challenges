/*
 * Implement Tip_Cal program as a GUI program that automatically updates the values when any value changes.
 */

package Tip_Calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;



public class Gui extends Tip_Cal {
    public static void main(String[] args) {
        /*
         * Instead of the user entering the value of the tip as a percentage, have the user
         * drag a slider that rates satisfaction with the server, using a range between 5%
         * and 20%.
         */
        JFrame frame = new JFrame("Tip Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(0, 2));

        /*until Integer input only  */
        
        JLabel billAmountLabel = new JLabel("Bill Amount:");
        panel.add(billAmountLabel);
        JTextField billInput = new JTextField();
        panel.add(billInput);

        

        JLabel tipRateLabel = new JLabel("Tip Rate:");
        panel.add(tipRateLabel);
        JSlider tipSlider = new JSlider(JSlider.HORIZONTAL, 5, 20, 15);
        panel.add(tipSlider);
        tipSlider.setPaintTicks(true);
        tipSlider.setPaintLabels(true);
        tipSlider.setMajorTickSpacing(5);
        tipSlider.setMinorTickSpacing(1);
        tipSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tipRateLabel.setText("Tip Rate: " + tipSlider.getValue() + "%");
            }
        });

        JLabel tipAmountLabel = new JLabel("Tip Amount:");
        panel.add(tipAmountLabel);
        JLabel tipAmount = new JLabel();
        panel.add(tipAmount);

        JLabel totalAmountLabel = new JLabel("Total Amount:");
        panel.add(totalAmountLabel);
        JLabel totalAmount = new JLabel();
        panel.add(totalAmount);

        JButton calculate = new JButton("Calculate");
        panel.add(calculate);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double billAmount = Double.parseDouble(billInput.getText());
                double tipRate = tipSlider.getValue();
                double tipAmountValue = billAmount * (tipRate / 100);
                double totalAmountValue = billAmount + tipAmountValue;
                tipAmount.setText("$" + tipAmountValue);
                totalAmount.setText("$" + totalAmountValue);
            }
        });

        frame.setVisible(true);



    }
}
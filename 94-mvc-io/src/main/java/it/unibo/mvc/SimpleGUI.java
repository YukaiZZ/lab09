package it.unibo.mvc;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first Simple GUI");

    private SimpleGUI(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel southPanel = new JPanel();
        final JTextArea area = new JTextArea();
        final JTextField field = new JTextField();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        // add the function of printf
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                ctrl.setNextString(field.getText());
                ctrl.printsCurrentString();
            }
        });
        // add the function of Show History
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final List<String> history = ctrl.getHistoryPrinted();
                final String historyText = String.join("\n", history); 
                area.setText(historyText);
            }
        });
        panel.add(field, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        southPanel.add(showHistory);
        southPanel.add(print);
        // Frame configuration
        frame.setContentPane(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }
    /**
     * Launches the application.
     *
     * @param a
     *            unused
     */
    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }

}

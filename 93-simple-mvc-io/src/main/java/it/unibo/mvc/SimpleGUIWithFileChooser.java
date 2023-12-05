package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My second Java graphical interface");

    private SimpleGUIWithFileChooser(final Controller cl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        final JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        final JTextArea textA = new JTextArea();
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    cl.save(textA.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        final JTextField path = new JTextField(cl.getCurrentFilePath());
        path.setEditable(false);
        final JButton browse = new JButton("Browse...");
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final JFileChooser fc = new JFileChooser("Choose where to save");
                fc.setSelectedFile(cl.getCurrentFile());
                final int result = fc.showSaveDialog(frame);
                switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    final File newDest = fc.getSelectedFile();
                    cl.setCurrentFile(newDest);
                    path.setText(newDest.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, result, "Meh!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        p2.add(browse, BorderLayout.LINE_END);
        p2.add(path, BorderLayout.CENTER);

        p1.add(textA, BorderLayout.CENTER);
        p1.add(save, BorderLayout.SOUTH);
        p1.add(p2, BorderLayout.NORTH);
        frame.setContentPane(p1);
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
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
}

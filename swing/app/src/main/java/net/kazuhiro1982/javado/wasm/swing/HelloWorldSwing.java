package net.kazuhiro1982.javado.wasm.swing;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HelloWorldSwing {

    public static void main(String[] args) {
        // // Create the frame
        JFrame frame = new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a label
        JLabel label = new JLabel("Hello, World!");
        Font font = new Font("Arial", Font.PLAIN, 32);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(label);

        // Create a button
        JButton button = new JButton("Click Me!");
        Font bFont = new Font("Arial", Font.PLAIN, 24);
        button.setPreferredSize(new Dimension(400, 80));
        button.setFont(bFont);
        frame.getContentPane().add(button, "South");

        // Add an action listener to the button
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button was clicked!"));

        // Display the frame
        frame.setVisible(true);
    }
}

package com.zaspa.SNChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Main {
    public static void main(String[] args) {

        getSN.getSerialNumberFromOS();
        String serialNumber = getSN.getSerialNumber();

        JFrame frame = new JFrame("Serial Number Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        JPanel serialNumberPanel = new JPanel();
        serialNumberPanel.setLayout(new BoxLayout(serialNumberPanel, BoxLayout.Y_AXIS));
        serialNumberPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JLabel serialNumberLabel = new JLabel("Your serial number:", SwingConstants.CENTER);
        serialNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        serialNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel serialNumberValue = new JLabel(serialNumber, SwingConstants.CENTER);
        serialNumberValue.setFont(new Font("Calibri", Font.BOLD, 24));
        serialNumberValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        serialNumberPanel.add(Box.createVerticalGlue()); // Space above
        serialNumberPanel.add(serialNumberLabel);
        serialNumberPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        serialNumberPanel.add(serialNumberValue);
        serialNumberPanel.add(Box.createVerticalGlue()); // Space below
        panel.add(serialNumberPanel, BorderLayout.CENTER);

        JButton copyButton = new JButton("Copy");
        copyButton.setBackground(new Color(70, 130, 180));
        copyButton.setForeground(Color.WHITE);
        copyButton.setFocusPainted(false);
        copyButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        copyButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(copyButton, BorderLayout.SOUTH);

        copyButton.addActionListener(e -> {
            StringSelection stringSelection = new StringSelection(serialNumber);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        });

        frame.setVisible(true);
    }
}
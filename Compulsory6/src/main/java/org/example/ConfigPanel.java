package org.example;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinnerRow;

    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        // spinner = a single line input field that allows the user to select a number or an object value from an ordered sequence
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));


        spinnerRow = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createButton = new JButton("Create");
        add(label); //JPanel uses FlowLayout by default
        add(spinner);
        add(spinnerRow);
        add(createButton);
    }

}
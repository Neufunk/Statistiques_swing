package com.asdnamur.statistiques;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by johnathanv on 5/04/2017.
 */
public class Indicateur {

    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel panel = new JPanel();
    JLabel title = new JLabel("Recherche par indicateur");
    JLabel label1 = new JLabel("Indicateurs : ");
    JComboBox comboIndicateurs = new JComboBox();
    JLabel label2 = new JLabel("Période : ");
    JComboBox comboPeriode = new JComboBox();
    JTextField textBox = new JTextField(20);

    public Indicateur() {
        JFrame frame = new JFrame();
        frame.setTitle("Fenêtre de recherche par indicateurs - v0.1");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);

        Font fTitle = new Font("ARIAL", Font.BOLD, 30);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(fTitle);
        title.setForeground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        comboIndicateurs.setSize(150, 10);
        comboPeriode.setSize(150, 10);
        textBox.setEditable(false);
        mainPanel.setBackground(Color.RED);

        panel.setBackground(Color.ORANGE);
        panel.setBorder(new EmptyBorder(100, 100, 100, 100));
        panel.add(label1);
        panel.add(comboIndicateurs);
        panel.add(label2);
        panel.add(comboPeriode);

        mainPanel.add(panel, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(title, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(textBox, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));



    }
}

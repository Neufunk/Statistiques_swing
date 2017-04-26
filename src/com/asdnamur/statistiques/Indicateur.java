package com.asdnamur.statistiques;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class Indicateur {

    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel panel = new JPanel();
    JLabel title = new JLabel("Recherche par indicateur");
    JLabel title2 = new JLabel("Indicateurs : ");
    String[] monthArray = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre", "TOTAL 2017"};
    Vector<String> indicList = new Vector<String>();
    Vector<String> periodList = new Vector<String>();
    JComboBox<String> comboIndicateurs = new JComboBox<String>(indicList);
    JLabel title3 = new JLabel("Période : ");
    JComboBox<String> comboPeriod = new JComboBox<>(periodList);
    JTextField tResult = new JTextField(20);
    private Map<String, Integer> periodMap = new HashMap<>();
    private Map<String, Integer> indicMap = new HashMap<>();


    public Indicateur() throws IOException, InvalidFormatException {
        JFrame frame = new JFrame();
        frame.setTitle("Fenêtre de recherche par indicateurs - beta 0.1");
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
        comboPeriod.setSize(150, 10);
        tResult.setEditable(false);
        mainPanel.setBackground(new Color(0, 110, 130));

        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(80, 80, 80, 80));
        panel.add(title2);
        panel.add(comboIndicateurs);
        comboIndicateurs.setEditable(false);
        panel.add(title3);
        panel.add(comboPeriod);
        comboPeriod.setEditable(false);

        mainPanel.add(panel, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(title, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(tResult, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));


        // Initialisation du Workbook avec fichier EXCEL
        Workbook wb = WorkbookFactory.create(new File("C://Users/johnathanv/Desktop/Namur 2017.xls"));
        Sheet sheet902;
        sheet902 = wb.getSheetAt(0);

        // ActionListener sur les COMBO
        comboPeriod.addActionListener(e -> {
            int cell = periodMap.get(comboPeriod.getSelectedItem());
            int row = indicMap.get(comboIndicateurs.getSelectedItem());
            System.out.println("row: " + row + ", cell: " + cell);
            tResult.setText(sheet902.getRow(row).getCell(cell).toString());
        });

        comboIndicateurs.addActionListener(e -> {
            int cell = periodMap.get(comboPeriod.getSelectedItem());
            int row = indicMap.get(comboIndicateurs.getSelectedItem());
            System.out.println("row: " + row + ", cell: " + cell);
            tResult.setText(sheet902.getRow(row).getCell(cell).toString());
        });

        /* // Itération pour éviter NullPointerException
        for (int i = 5; i < 165; i++) {
            Row row = sheet902.getRow(i);
            if (row == null) {
                System.out.println("Empty Row");
                continue;
            }
            for (int j = 3; j < 16; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    System.out.println("Empty Cell");
                    continue;
                } */

                // Boucles pour récupérer les infos nécessaires + mise en MAP pour récupérer le résultat
                int rowTab = 5;
                int cellTab = 3;
                while (cellTab < 16) {
                    String label = sheet902.getRow(1).getCell(cellTab).toString();
                    periodList.add(label);
                    periodMap.put(label, cellTab);
                    cellTab++;
                }

                while (rowTab < 165) {
                    String label2 = sheet902.getRow(rowTab).getCell(1).toString();
                    indicList.add(label2);
                    indicMap.put(label2, rowTab);
                    rowTab++;
                }
                System.out.println("Suite de l'exécution avec succès");
            }
        }

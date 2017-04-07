package com.asdnamur.statistiques;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


public class Indicateur {

    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel panel = new JPanel();
    JLabel title = new JLabel("Recherche par indicateur");
    JLabel label1 = new JLabel("Indicateurs : ");
    String[] monthArray = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre", "TOTAL 2017"};
    Vector indicList = new Vector();
    JComboBox comboIndicateurs = new JComboBox(indicList);
    JLabel label2 = new JLabel("Période : ");
    JComboBox comboPeriode = new JComboBox(monthArray); // Combo avec le Array Mois
    JTextField textBox = new JTextField(20);


    public Indicateur() throws IOException, InvalidFormatException {
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
        mainPanel.setBackground(new Color(0, 110, 130));

        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(80, 80, 80, 80));
        panel.add(label1);
        panel.add(comboIndicateurs);
        panel.add(label2);
        panel.add(comboPeriode);

        mainPanel.add(panel, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(title, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(textBox, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        Workbook wb = WorkbookFactory.create(new File("C:/Users/johnathanv/Desktop/Namur 2017.xls"));
        Sheet sheet902 = wb.getSheetAt(0);
        Iterator rowIter = sheet902.rowIterator();
        int row = 5;
        int cell = 1;
        while (row < 165){
            indicList.add(sheet902.getRow(row).getCell(cell).toString());
            row++;
        }
    }
}

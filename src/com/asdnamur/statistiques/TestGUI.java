package com.asdnamur.statistiques;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestGUI {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JPanel mainPanel;
    private JLabel label1;
    private JLabel label2;
    private JButton backButton;

    public TestGUI()

    {
        JFrame frame = new JFrame("Test recherche indicateur - 0.1");
        frame.setContentPane(mainPanel);
        frame.setSize(330, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        backButton.setText("\u25C4");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }

}

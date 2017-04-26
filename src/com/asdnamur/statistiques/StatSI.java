package com.asdnamur.statistiques;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class StatSI {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JButton a2013Button;
    private JButton a2014Button;
    private JButton a2017Button1;
    private JButton a2018Button;
    private JButton a2019Button;
    private JButton closeButton;
    private JButton a2014Button1;
    private JButton a2020Button;
    private JComboBox comboCentre;
    private JComboBox comboPeriode;
    private JComboBox comboYear1;
    private JComboBox comboYear2;
    private JComboBox comboYear3;
    private JComboBox comboIndic;
    private JCheckBox graphCheckBox;
    private JButton generateButton;
    private JLabel labelYear1;
    private JLabel labelYear2;
    private JLabel labelYear3;
    private JLabel labelCentre;
    private JLabel labelPeriode;
    private JLabel labelIndic;
    String selectedChamp = "";
    String tableName = "";
    int indexIndic = 0;


    public StatSI() {
        // FRAME
        JFrame frame = new JFrame();
        frame.setTitle("Statistiques Soins Infirmiers");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);
        UIManager.put("TabbedPane.selected", new Color(120, 190, 60));
        tabbedPane1.setOpaque(false);
        tabbedPane1.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                highlight = Color.WHITE;
                lightHighlight = Color.WHITE;
                shadow = Color.BLACK;
                darkShadow = Color.BLACK;
                focus = (new Color(120, 190, 60));
                contentBorderInsets = new Insets(0, 0, 0, 0);
            }
        });

        // COMBOBOX
        comboCentre.addItem("Province");
        comboCentre.addItem("Namur");
        comboCentre.addItem("Eghezée");
        comboCentre.addItem("Ciney");
        comboCentre.addItem("Philippeville");
        comboCentre.addItem("Gedinne");

        comboPeriode.addItem("Année Complète");
        comboPeriode.addItem("Janvier");
        comboPeriode.addItem("Février");
        comboPeriode.addItem("Mars");
        comboPeriode.addItem("Avril");
        comboPeriode.addItem("Mai");
        comboPeriode.addItem("Juin");
        comboPeriode.addItem("Juillet");
        comboPeriode.addItem("Août");
        comboPeriode.addItem("Septembre");
        comboPeriode.addItem("Octobre");
        comboPeriode.addItem("Novembre");
        comboPeriode.addItem("Décembre");

        // INDICATEURS DANS COMBO
        Connection connexion = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\johnathanv\\Desktop\\Statistiques SI.accdb", "", "");
            Statement st = connexion.createStatement();
            String sql = "SELECT * FROM CJBNamur2016"; // Requête
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String listeIndicateurs = rs.getString("Champ2");
                comboIndic.addItem(listeIndicateurs);
            }
        } catch (Exception e1) {
            System.err.println("Exception trouvée : ");
            System.err.println(e1.getMessage());
        }
        comboIndic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexIndic = comboIndic.getSelectedIndex();
            }
        });

        // BUTTONS
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int centreIndex = comboCentre.getSelectedIndex();
                if (centreIndex == 0) {
                    tableName = "CJBNamur2016";
                } else if (centreIndex == 1) {
                    tableName = "t961_2016";
                } else if (centreIndex == 2) {
                    tableName = "t931_2016";
                } else if (centreIndex == 3) {
                    tableName = "t913_2016";
                } else if (centreIndex == 4) {
                    tableName = "t902_2016";
                } else if (centreIndex == 5) {
                    tableName = "t923_2016";
                }
                int periodeIndex = comboPeriode.getSelectedIndex();
                if (periodeIndex == 0) {
                    selectedChamp = "champ16";
                } else if (periodeIndex == 1) {
                    selectedChamp = "Champ4";
                } else if (periodeIndex == 2) {
                    selectedChamp = "Champ5";
                } else if (periodeIndex == 3) {
                    selectedChamp = "Champ6";
                } else if (periodeIndex == 4) {
                    selectedChamp = "Champ7";
                } else if (periodeIndex == 5) {
                    selectedChamp = "Champ8";
                } else if (periodeIndex == 6) {
                    selectedChamp = "Champ9";
                } else if (periodeIndex == 7) {
                    selectedChamp = "Champ10";
                } else if (periodeIndex == 8) {
                    selectedChamp = "Champ11";
                } else if (periodeIndex == 9) {
                    selectedChamp = "Champ12";
                } else if (periodeIndex == 10) {
                    selectedChamp = "Champ13";
                } else if (periodeIndex == 11) {
                    selectedChamp = "Champ14";
                } else {
                    selectedChamp = "Champ15";
                }
                System.out.println(selectedChamp);
                System.out.println(tableName);

                JOptionPane.showMessageDialog(frame, "TABLE : " + tableName + " & CHAMP : " + selectedChamp);

            }
        });

        closeButton.addActionListener(click -> frame.dispose());
    }


}

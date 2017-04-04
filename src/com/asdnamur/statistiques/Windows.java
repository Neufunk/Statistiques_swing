package com.asdnamur.statistiques;

import javax.swing.*;
import java.awt.*;

class Windows extends JFrame {

    Windows(){
        // Propriété fenêtre
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Aide & Soins à Domicile - Statistiques");
        jFrame.setSize(1280, 720);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setBackground(Color.WHITE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        // Backgrounds
        JPanel jBackgroundG = new JPanel();
        jBackgroundG.setBackground(Color.WHITE);

        JPanel jBackgroundD = new JPanel();
        jBackgroundD.setBackground(Color.WHITE);


        // Boutons
        JButton bAvj = new JButton("AVJ");
        bAvj.setBackground(new Color(120, 190, 60));
        JButton bSi = new JButton("SI");
        bSi.setBackground(new Color(0, 110, 130));

        // Mise en forme
        jFrame.getContentPane().setLayout(new GridLayout(1,2));
        jFrame.getContentPane().add(jBackgroundG);
        jBackgroundG.add(bAvj);
        jFrame.getContentPane().add(jBackgroundD);
        jBackgroundD.add(bSi);
    }


}
package com.asdnamur.statistiques;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;


public class HomePage extends JFrame {

    JFrame frame = new JFrame();
    JPanel panelAVJ = new JPanel();
    JPanel panelSI = new JPanel();

    public HomePage() {

        // un panneau pour la partie bouton plus image au centre
        JPanel buttonPanel = new JPanel(new GridBagLayout());

        // Images + Resize
        ImageIcon imageIcon = new ImageIcon("./res/graphique.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        JLabel imageCenter = new JLabel(new ImageIcon(newimg));

        ImageIcon imageIcon2 = new ImageIcon("./res/ASD_logo.jpg"); // load the image to a imageIcon
        Image image2 = imageIcon2.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(300, 120, Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg2);  // transform it back
        JLabel imageLogo = new JLabel(new ImageIcon(newimg2));

        // Bouttons
        Font fButtons = new Font("ARIAL", Font.BOLD, 20); // Button's Font
        JButton buttonLeft = new JButton("Département AVJ");
        // buttonLeft.setBorderPainted(false); // suppression bordure bouton
        buttonLeft.setBorder(new RoundedBorder(50)); // TODO : Continuer les bords arrondis des boutons
        buttonLeft.setBackground(new Color(120, 190, 60));
        buttonLeft.setForeground(Color.WHITE);
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                frame.setContentPane(panelAVJ);
                frame.setTitle("Statistiques AVJ");
                frame.revalidate();
            }
        });

        JButton buttonRight = new JButton("Département SI");
        // buttonRight.setBorderPainted(false);
        buttonRight.setBackground(new Color(0, 110, 130));
        buttonRight.setForeground(Color.WHITE);
        buttonLeft.setFont(fButtons);
        buttonRight.setFont(fButtons);
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                frame.setContentPane(panelSI);
                frame.setTitle("Statistiques SI");
                frame.revalidate();
            }
        });

        JButton buttonClose = new JButton ("Fermer");
        buttonClose.setBackground(Color.RED);
        buttonClose.setForeground(Color.WHITE);
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Contraintes aux boutons, pour qu'ils soient de même largeur
        buttonLeft.setMinimumSize(new Dimension(Math.max(buttonLeft.getMinimumSize().width, buttonRight.getMinimumSize().width),
                buttonLeft.getMinimumSize().height));
        buttonRight.setMinimumSize(new Dimension(Math.max(buttonLeft.getMinimumSize().width, buttonRight.getMinimumSize().width),
                buttonRight.getMinimumSize().height));
        buttonLeft.setPreferredSize(buttonLeft.getMinimumSize());
        buttonRight.setPreferredSize(buttonRight.getMinimumSize());

        // une contrainte pour les boutons, pour qu'ils s'étendent dans la hauteur, et dans la largeur, en se partageant équitablement entre eux deux l'espace
        GridBagConstraints gbcButton = new GridBagConstraints(0, 0, 1, 1, 0.5, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0);
        // une contriante pour l'image au centre
        GridBagConstraints gbcImage = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 0, 0);

        // le bouton de gauche
        buttonPanel.add(buttonLeft, gbcButton);

        // l'image centrale
        buttonPanel.add(imageCenter, gbcImage);

        // le bouton de droite
        gbcButton.gridx = 2;
        buttonPanel.add(buttonRight, gbcButton);

        // un panel global
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);

        // je mets le panel avec les boutons dans le panel global
        mainPanel.add(buttonPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));

        // la partie au sud du panel global, avec un texte centrés
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // le BoxLayout vertical met les composants en colonne
        JLabel title = new JLabel("Statistiques"); // le texte
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT); // je centre le texte
        Font fTitle = new Font("ARIAL", Font.BOLD, 30);
        title.setFont(fTitle);
        southPanel.add(title);
        southPanel.setBackground(Color.WHITE);

        // northPanel avec logo ASD
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        imageLogo.setAlignmentX(JLabel.CENTER_ALIGNMENT); // je centre l'image dans le boxlayout
        northPanel.add(imageLogo);
        // northPanel dans le panel global
        mainPanel.add(northPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));
        // southPanel dans le panel global
        mainPanel.add(southPanel, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));
        mainPanel.add(buttonClose, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE, new Insets(10, 10, 0, 0), 0, 0));


        // je met le panel global au centre de la fenêtre
        frame.add(mainPanel);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Aide & Soins à Domicile en province de Namur - Statistiques");

        // Panel Global AVJ
        panelAVJ.setLayout(new BorderLayout());
        panelAVJ.setBorder(new EmptyBorder(3, 3, 3, 3));
        panelAVJ.setBackground(new Color(120, 190, 60));

        JPanel avjTop = new JPanel();
        avjTop.setLayout(new BorderLayout());
        JButton buttonBack = new JButton ("\u25C4");
        buttonBack.setSize(100, 100);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                frame.setContentPane(mainPanel);
                frame.setTitle("Aide & Soins à Domicile en province de Namur - Statistiques");
                frame.revalidate();
            }
        });
        avjTop.add(buttonBack, BorderLayout.LINE_START);
        avjTop.setBackground(new Color(120, 190, 60));

        panelAVJ.add(avjTop, BorderLayout.PAGE_START);

        //Panel Global SI
        panelSI.setLayout(new BorderLayout());
        panelSI.setBackground(new Color(0, 110, 130));
        panelSI.setBorder(new EmptyBorder(3, 3, 3, 3));

        JPanel siTop = new JPanel();
        siTop.setLayout(new BorderLayout());
        JButton buttonBack2 = new JButton("\u25C4");
        buttonBack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                frame.setContentPane(mainPanel);
                frame.setTitle("Aide & Soins à Domicile en province de Namur - Statistiques");
                frame.revalidate();
            }
        });
        siTop.add(buttonBack2, BorderLayout.LINE_START);
        siTop.setBackground(new Color(0, 110, 130));

        panelSI.add(siTop, BorderLayout.PAGE_START);
    }
}
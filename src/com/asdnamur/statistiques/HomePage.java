package com.asdnamur.statistiques;

import com.sun.deploy.ui.ImageLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;


public class HomePage extends JFrame {

    JFrame frame = new JFrame();
    JPanel panelAVJ = new JPanel();
    JPanel panelSI = new JPanel();

    Font fButtons = new Font("ARIAL", Font.BOLD, 20);
    Font fTitle = new Font("ARIAL", Font.BOLD, 30);


    public HomePage() throws IOException {

        // un panneau pour la partie bouton plus image au centre
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.WHITE);

        // Images + Resize
        InputStream graphiqueURL = getClass().getResourceAsStream("/resources/graphique.png");
        Image graphique = ImageIO.read(graphiqueURL);
        ImageIcon imageIcon = new ImageIcon((graphique)); // load the image to an imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        JLabel imageCenter = new JLabel(new ImageIcon(newimg));

        InputStream logoURL = getClass().getResourceAsStream("/resources/ASD_logo.jpg");
        Image logo = ImageIO.read(logoURL);
        ImageIcon imageIcon2 = new ImageIcon(logo); // load the image to an imageIcon
        Image image2 = imageIcon2.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(300, 120, Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg2);  // transform it back
        JLabel imageLogo = new JLabel(new ImageIcon(newimg2));

        // Bouttons
        JButton buttonLeft = new JButton("Département AVJ");
        buttonLeft.setBackground(new Color(120, 190, 60));
        buttonLeft.setForeground(Color.WHITE);
        buttonLeft.setFont(fButtons);
        buttonLeft.setFocusPainted(false);
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                JOptionPane.showMessageDialog(frame, "The world could always use more heroes.");
            }
        });

        JButton buttonRight = new JButton("Département SI");
        buttonRight.setBackground(new Color(0, 110, 130));
        buttonRight.setForeground(Color.WHITE);
        buttonRight.setFont(fButtons);
        buttonRight.setFocusPainted(false);
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                new StatSI();
            }
        });

        JButton buttonClose = new JButton("Fermer");
        buttonClose.setBackground(new Color(232, 79, 68));
        buttonClose.setForeground(Color.WHITE);
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton buttonIndicateur = new JButton("Indicateurs");
        buttonIndicateur.setForeground(Color.WHITE);
        buttonIndicateur.setVisible(false);
        buttonIndicateur.setBackground(new Color(225, 165, 50));
        buttonIndicateur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Indicateur();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InvalidFormatException e1) {
                    e1.printStackTrace();
                }
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

        // panel avec les boutons dans le panel global
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
        mainPanel.add(buttonIndicateur, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE, new Insets(10, 10, 0, 0), 0, 0));


        // panel global au centre de la fenêtre
        frame.add(mainPanel);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Aide & Soins à Domicile en province de Namur - Statistiques");

    }
}
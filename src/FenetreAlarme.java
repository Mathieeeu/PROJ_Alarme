import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**********************************************************************/
/*      Classe pour la fenêtre de création d'une anomalie             */
/**********************************************************************/

public class FenetreAlarme extends JFrame {

    public FenetreAlarme(ArrayList<CapteurGaz> capteurs_gaz, ArrayList<CapteurIncendie> capteurs_incendie, ArrayList<CapteurRadiation> capteurs_radiation) {

        // Création de la fenêtre
        this.setTitle("Création d'une anomalie");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Choix du batiment, du type d'anomalie, du niveau d'importance
        String[] batiments = {"Batiment A", "Batiment B", "Batiment C"};
        String[] types_anomalies = {"Incendie", "Gaz", "Radiation"};
        String[] niveaux_importance = {"1", "2", "3"};
        JLabel batiment = new JLabel("Batiment : ");
        JComboBox<String> batiments_list = new JComboBox<>(batiments);
        JLabel type_anomalie = new JLabel("Type d'anomalie : ");
        JComboBox<String> types_anomalies_list = new JComboBox<>(types_anomalies);
        JLabel niveau_importance = new JLabel("Niveau d'importance : ");
        JComboBox<String> niveaux_importance_list = new JComboBox<>(niveaux_importance);
        JLabel niveau_gaz_label = new JLabel("Niveau de gaz : ");
        JTextField niveau_gaz = new JTextField("100", 5);
        JLabel type_gaz_label = new JLabel("Type de gaz : ");
        JTextField type_gaz = new JTextField("CO2", 5);
        JLabel niveau_radiation_label = new JLabel("Niveau de radiation : ");
        JTextField niveau_radiation = new JTextField("50", 5);
        JTextField date = new JTextField("01/01/2024", 10);
        JButton bouton = new JButton("Créer l'anoamlie");

        // Création des panels
        JPanel panel_batiment = new JPanel();
        panel_batiment.add(batiment);
        panel_batiment.add(batiments_list);
        JPanel panel_type_anomalie = new JPanel();
        panel_type_anomalie.add(type_anomalie);
        panel_type_anomalie.add(types_anomalies_list);
        JPanel panel_niveau_importance = new JPanel();
        panel_niveau_importance.add(niveau_importance);
        panel_niveau_importance.add(niveaux_importance_list);
        JPanel panel_gaz = new JPanel();
        panel_gaz.add(niveau_gaz_label);
        panel_gaz.add(niveau_gaz);
        panel_gaz.add(type_gaz_label);
        panel_gaz.add(type_gaz);
        panel_gaz.setVisible(false);
        JPanel panel_radiation = new JPanel();
        panel_radiation.add(niveau_radiation_label);
        panel_radiation.add(niveau_radiation);
        panel_radiation.setVisible(false);
        JPanel panel_date = new JPanel();
        panel_date.add(date);
        JPanel panel_bouton = new JPanel();
        panel_bouton.add(bouton);

        // Affichage des champs en fonction du type d'anomalie
        types_anomalies_list.addActionListener(e -> {
            if (types_anomalies_list.getSelectedItem().equals("Gaz")) {
                panel_gaz.setVisible(true);
                panel_radiation.setVisible(false);
            } else if (types_anomalies_list.getSelectedItem().equals("Incendie")) {
                panel_gaz.setVisible(false);
                panel_radiation.setVisible(false);
            } else if (types_anomalies_list.getSelectedItem().equals("Radiation")) {
                panel_gaz.setVisible(false);
                panel_radiation.setVisible(true);
            }
        });

        // Ajout des panels à la fenêtre
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(panel_batiment);
        panel.add(panel_type_anomalie);
        panel.add(panel_niveau_importance);
        panel.add(panel_gaz);
        panel.add(panel_radiation);
        panel.add(panel_date);
        panel.add(panel_bouton);
        this.setContentPane(panel);

        // Création de l'anomalie
        bouton.addActionListener(e -> {
            String batiment_choisi = (String) batiments_list.getSelectedItem();
            String type_anomalie_choisi = (String) types_anomalies_list.getSelectedItem();
            int niveau_importance_choisi = Integer.parseInt((String) niveaux_importance_list.getSelectedItem());
            String date_choisi = date.getText();
            if (type_anomalie_choisi.equals("Gaz")) {
                int niveau_gaz_choisi = Integer.parseInt(niveau_gaz.getText());
                String type_gaz_choisi = type_gaz.getText();
                if (batiment_choisi == "Batiment A") {
                    capteurs_gaz.get(0).detecterAnomalie(niveau_gaz_choisi, type_gaz_choisi, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment B") {
                    capteurs_gaz.get(1).detecterAnomalie(niveau_gaz_choisi, type_gaz_choisi, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment C") {
                    capteurs_gaz.get(2).detecterAnomalie(niveau_gaz_choisi, type_gaz_choisi, date_choisi, niveau_importance_choisi);
                }
            } else if (type_anomalie_choisi.equals("Incendie")) {
                boolean feu = true;
                if (batiment_choisi == "Batiment A") {
                    capteurs_incendie.get(0).detecterAnomalie(feu, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment B") {
                    capteurs_incendie.get(1).detecterAnomalie(feu, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment C") {
                    capteurs_incendie.get(2).detecterAnomalie(feu, date_choisi, niveau_importance_choisi);
                }
            } else if (type_anomalie_choisi.equals("Radiation")) {
                int niveau_radiation_choisi = Integer.parseInt(niveau_radiation.getText());
                if (batiment_choisi == "Batiment A") {
                    capteurs_radiation.get(0).detecterAnomalie(niveau_radiation_choisi, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment B") {
                    capteurs_radiation.get(1).detecterAnomalie(niveau_radiation_choisi, date_choisi, niveau_importance_choisi);
                }
                if (batiment_choisi == "Batiment C") {
                    capteurs_radiation.get(2).detecterAnomalie(niveau_radiation_choisi, date_choisi, niveau_importance_choisi);
                }
            }
        });

        // Affichage de la fenêtre 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/4-this.getSize().width/4, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/********************************************************************/
/*      Classe pour permettre une bonne mise en forme des boutons   */
/********************************************************************/

public class FenetreMoniteur extends JFrame implements ActionListener {
    
    public FenetreMoniteur(ArrayList<Moniteur> moniteurs) {

        // Création de la fenêtre
        this.setTitle("Affichage des evenements des moniteurs");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Choix d'un moniteur, liste d'evenements du moniteur
        String[] noms_moniteurs = new String[moniteurs.size()];
        for (int i = 0; i < moniteurs.size(); i++) {
            noms_moniteurs[i] = moniteurs.get(i).getNom();
        }
        JLabel moniteur = new JLabel("Moniteur : ");
        JComboBox<String> moniteurs_list = new JComboBox<>(noms_moniteurs);
        String[] columnNames = {"Type", "Détails","Moniteur"}; // Type correspond à l'evenement, la colonne Détails contient un bouton pour afficher les détails de l'evenement
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable liste_evenements = new JTable(tableModel);
        // les trois lignes suivantes sont là pour cacher la colonne du type de moniteur (pas trouvé mieux)
        liste_evenements.getColumnModel().getColumn(2).setMinWidth(0);
        liste_evenements.getColumnModel().getColumn(2).setMaxWidth(0);
        liste_evenements.getColumnModel().getColumn(2).setWidth(0);
        liste_evenements.getColumn("Détails").setCellRenderer(new ButtonRenderer());
        liste_evenements.getColumn("Détails").setCellEditor(new ButtonEditor(new JCheckBox(), moniteurs));
        JScrollPane scrollPane = new JScrollPane(liste_evenements);

        // Affichage des evenements du moniteur selectionné
        moniteurs_list.addActionListener(e -> {
            if (moniteurs_list.getSelectedItem().equals(moniteurs.get(0).getNom())) {
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurs.get(0).anomalies) {
                    tableModel.addRow(new Object[]{event.getType(), "Détails","A"});
                }
            }
            else if (moniteurs_list.getSelectedItem().equals(moniteurs.get(1).getNom())) {
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurs.get(1).anomalies) {
                    tableModel.addRow(new Object[]{event.getType(), "Détails","B"});
                }
            }
        });

        // Bouton actualiser
        JButton btn_actualiser = new JButton("Actualiser");
        btn_actualiser.addActionListener(e -> {
            if (moniteurs_list.getSelectedItem().equals(moniteurs.get(0).getNom())) {
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurs.get(0).anomalies) {
                    tableModel.addRow(new Object[]{event.getType(), "Détails","A"});
                }
            }
            else if (moniteurs_list.getSelectedItem().equals(moniteurs.get(1).getNom())) {
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurs.get(1).anomalies) {
                    tableModel.addRow(new Object[]{event.getType(), "Détails","B"});
                }
            }
        });

        // Création des panels
        JPanel panel_moniteur = new JPanel();
        panel_moniteur.add(moniteur);
        panel_moniteur.add(moniteurs_list);
        panel_moniteur.add(btn_actualiser);
        JPanel panel_liste_evenements = new JPanel();
        panel_liste_evenements.add(scrollPane);

        // Ajout des panels à la fenêtre
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(panel_moniteur);
        panel.add(panel_liste_evenements);
        this.setContentPane(panel);

        // Affichage de la fenêtre
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(3*dim.width/4-3*this.getSize().width/4, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

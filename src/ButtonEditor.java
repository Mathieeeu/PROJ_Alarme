import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/***************************************************************************/
/* Classe pour permettre une bonne mise en forme et fonctions des boutons  */
/***************************************************************************/

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private ArrayList<Moniteur> moniteurs;

    public ButtonEditor(JCheckBox checkBox, ArrayList<Moniteur> moniteurs) {
        super(checkBox);
        this.moniteurs = moniteurs;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        // Fonctionalités des boutons Détails et Traiter
        if (isPushed) {
            JTable table = (JTable) button.getParent();
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                isPushed = false;
                return label;
            }
            if (label.equals("Détails")) {
                String type = (String) table.getValueAt(selectedRow, 0);
                String moniteur = (String) table.getValueAt(selectedRow, 2);
                if (moniteur.equals("A")) {
                    AnomalieEvent event = null;                    
                    for (AnomalieEvent tempEvent : moniteurs.get(0).anomalies) {
                        if (tempEvent.getType().equals(type)) {
                            event = tempEvent;
                        }
                    }
                    Object[] options = {"Traiter", "Fermer"};
                    int choice = JOptionPane.showOptionDialog(button,
                            event.getDetails(),
                            "Détails de l'anomalie",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[0]);
                    if (choice == 0) {
                        moniteurs.get(0).traiterAnomalie(event);
                        // Si l'anomalie est de type gaz, on la traite aussi pour le moniteur de type B
                        if (event.getType().equals("Gaz")) {
                            moniteurs.get(1).traiterAnomalie(event);
                        }
                    }
                    
                } else if (moniteur.equals("B")) {
                    AnomalieEvent event = null;                    
                    for (AnomalieEvent tempEvent : moniteurs.get(1).anomalies) {
                        if (tempEvent.getType().equals(type)) {
                            event = tempEvent;
                        }
                    }
                    Object[] options = {"Traiter", "Fermer"};
                    int choice = JOptionPane.showOptionDialog(button,
                        event.getDetails(),
                        "Détails de l'anomalie",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]);
                    if (choice == 0) {
                        moniteurs.get(1).traiterAnomalie(event);
                        // Si l'anomalie est de type gaz, on la traite aussi pour le moniteur de type A
                        if (event.getType().equals("Gaz")) {
                            moniteurs.get(0).traiterAnomalie(event);
                        }
                    }
                }
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

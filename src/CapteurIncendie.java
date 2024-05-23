import javax.swing.JOptionPane;

/**********************************************************************/
/*      Classe pour la création d'un capteur d'incendie               */
/**********************************************************************/

public class CapteurIncendie extends Capteur {
    private boolean feu;

    public CapteurIncendie(String nom, String localisation, boolean feu) {
        super(nom, localisation);
        this.feu = feu;
    }

    public String toString() {
        return "CapteurIncendie [nom=" + super.nom + ", localisation=" + this.localisation + ", feu=" + this.feu + "]";
    }

    public void detecterAnomalie(boolean feu, String date, int niveau_importance) {
        this.feu = feu;
        if (this.feu) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            IncendieEvent event = new IncendieEvent(this, date, this.localisation, niveau_importance);
            for (AnomalieListener listener : listeners){
                listener.nouvelleAnomalie(event);
            }
            JOptionPane.showMessageDialog(null, event.getDetails(), "Anomalie", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            for (AnomalieListener listener : listeners){
                listener.aucuneAnomalie();
            }
        }
    }

    public void addAnomalieListener(AnomalieListener listener){
        // si listener de type A
        if (listener instanceof MoniteurA){
            listeners.add(listener);
        }
        else {
            System.out.println("Le capteur d'incendie ne peut pas être surveillé par ce moniteur.");
        }
    }
}
import javax.swing.JOptionPane;

/**********************************************************************/    
/*      Classe pour la création d'un capteur de radiation             */
/**********************************************************************/

public class CapteurRadiation extends Capteur{
    private int niveau_radiation;
    private int seuil_niveau_radiation;
    
    public CapteurRadiation(String nom, String localisation) {
        super(nom, localisation);
        this.niveau_radiation = 0;
        this.seuil_niveau_radiation = 10;
    }

    public String toString() {
        return "CapteurRadiation [nom=" + super.nom + ", localisation=" + this.localisation + ", niveau_radiation=" + this.niveau_radiation + "/" + this.seuil_niveau_radiation + "]";
    }

    public void detecterAnomalie(int niveau_radiation, String date, int niveau_importance) {
        this.niveau_radiation = niveau_radiation;
        if (this.niveau_radiation >= this.seuil_niveau_radiation) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            RadiationEvent event = new RadiationEvent(this, date, this.localisation, niveau_importance, this.niveau_radiation);
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
        // si listener de type B
        if (listener instanceof MoniteurB){
            listeners.add(listener);
        }
        else {
            System.out.println("Le capteur de radiation ne peut pas être surveillé par ce moniteur.");
        }
    }
}

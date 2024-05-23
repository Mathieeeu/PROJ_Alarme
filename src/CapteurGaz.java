import javax.swing.JOptionPane;

public class CapteurGaz extends Capteur {
    private String type;
    private int niveau_gaz;
    private int seuil_niveau_gaz;

    public CapteurGaz(String nom, String localisation, String type, int niveau_gaz, int seuil_niveau_gaz) {
        super(nom,localisation);
        this.type = type;
        this.niveau_gaz = niveau_gaz;
        this.seuil_niveau_gaz = seuil_niveau_gaz;
    }

    public String toString() {
        return "CapteurGaz [nom=" + super.nom + ", localisation=" + this.localisation + ", type=" + this.type + ", niveau_gaz=" + this.niveau_gaz + "/" + this.seuil_niveau_gaz + "]";
    }

    public void detecterAnomalie(int niveau_gaz, String type, String date, int niveau_importance) {
        this.niveau_gaz = niveau_gaz;
        this.type = type;
        if (this.niveau_gaz >= this.seuil_niveau_gaz) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            GazEvent event = new GazEvent(this, date, this.localisation, niveau_importance, this.type, this.niveau_gaz, this.seuil_niveau_gaz);
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
        // si listener de type A ou B
        if (listener instanceof MoniteurA || listener instanceof MoniteurB){
            listeners.add(listener);
        }
        else {
            System.out.println("Le capteur de gaz ne peut pas être surveillé par ce moniteur.");
        }
    }
}

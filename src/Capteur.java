import java.util.ArrayList;

public abstract class Capteur {
    protected String nom;
    protected String localisation;
    protected ArrayList<AnomalieListener> listerners;


    public Capteur(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
        listerners = new ArrayList<AnomalieListener>();
    }

    public String toString() {
        return "Capt" + this.nom + " [localisation=" + this.localisation + "]";
    }

    public void addAnomalieListener(AnomalieListener listener) {
        listerners.add(listener);
    }

    public void removeAnomalieListener(AnomalieListener listener) {
        listerners.remove(listener);
    }

    public abstract void detecterAnomalie();
}

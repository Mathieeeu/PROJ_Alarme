import java.util.ArrayList;

public abstract class Capteur {
    protected String nom;
    protected String localisation;
    protected ArrayList<AnomalieListener> listeners;


    public Capteur(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
        listeners = new ArrayList<AnomalieListener>();
    }

    public String toString() {
        return "Capt" + this.nom + " [localisation=" + this.localisation + "]";
    }

    public void addAnomalieListener(AnomalieListener listener) {
        listeners.add(listener);
    }

    public void removeAnomalieListener(AnomalieListener listener) {
        listeners.remove(listener);
    }

    public abstract void detecterAnomalie();
}

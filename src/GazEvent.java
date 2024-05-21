// Classe abstraite GazEvent dérivée de AnomalieEvent

public class GazEvent extends AnomalieEvent {
    private String type;
    private int niveau_gaz;
    private int seuil_capteur;

    public GazEvent(Object source, String date, String localisation, int niveau_importance, String type, int niveau_gaz, int seuil_capteur) {
        super(source, date, localisation, niveau_importance);
        this.type = type;
        this.niveau_gaz = niveau_gaz;
        this.seuil_capteur = seuil_capteur;
    }

    public String toString() {
        return "GazEvent [date=" + super.date + ", localisation=" + super.localisation + ", niveau_importance=" + super.niveau_importance + "/3, gaz=" + this.type + ", niveau_gaz=" + this.niveau_gaz + "/" + this.seuil_capteur + "]";
    }

    public String getType() {
        return "Gaz";
    }

    public String getGaz() {
        return this.type;
    }

    public int getNiveauGaz() {
        return this.niveau_gaz;
    }

    public int getSeuilCapteur() {
        return this.seuil_capteur;
    }

    public String getDetails() {
        return "Gaz " + this.type + " à " + super.localisation + " de niveau " + this.niveau_gaz + "/" + this.seuil_capteur;
    }
}
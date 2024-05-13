// Classe abstraite RadiationEvent dérivée de AnomalieEvent

public class RadiationEvent extends AnomalieEvent {
    private int niveau_rad;

    public RadiationEvent(Object source, String date, String localisation, int niveau_importance, int niveau_rad) {
        super(source, date, localisation, niveau_importance);
        this.niveau_rad = niveau_rad;
    }

    public String toString() {
        return "RadiationEvent [date=" + super.date + ", localisation=" + super.localisation + ", niveau_importance=" + super.niveau_importance + "/3, radiation=" + this.niveau_rad + "/100]";
    }
}
// Classe abstraite GazEvent dérivée de AnomalieEvent

public class GazEvent extends AnomalieEvent {
    private String type;

    public GazEvent(Object source, String date, String localisation, int niveau_importance, String type) {
        super(source, date, localisation, niveau_importance);
        this.type = type;
    }

    public String toString() {
        return "GazEvent [date=" + super.date + ", localisation=" + super.localisation + ", niveau_importance=" + super.niveau_importance + "/3, gaz=" + this.type + "]";
    }
}
// classe abstraite dérivée de AnomalieEvent

public class IncendieEvent extends AnomalieEvent {

    public IncendieEvent(Object source, String date, String localisation, int niveau_importance) {
        super(source, date, localisation, niveau_importance);
    }

    public String toString() {
        return "IncendieEvent [date=" + super.date + ", localisation=" + super.localisation + ", niveau_importance=" + super.niveau_importance + "/3]";
    }

    public String getType() {
        return "Incendie";
    }

    public String getDetails() {
        return "Incendie à " + super.localisation + " de niveau " + super.niveau_importance + "/3";
    }
}
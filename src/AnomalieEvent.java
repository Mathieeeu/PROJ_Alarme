import java.util.EventObject;

/**********************************************************************/
/*      Classe abstraite pour les evenements des capteurs            */
/**********************************************************************/

public abstract class AnomalieEvent extends EventObject {
    protected String date;
    protected String localisation;
    protected int niveau_importance;

    public AnomalieEvent(Object source, String date, String localisation, int niveau_importance) {
        super(source);
        this.date = date;
        this.localisation = localisation;
        this.niveau_importance = niveau_importance;
    }

    public String toString() {
        return "AnomalieEvent [date=" + this.date + ", localisation=" + this.localisation + ", niveau_importance=" + this.niveau_importance + "/3]";
    }

    public String getDate() {
        return this.date;
    }

    public String getLocalisation() {
        return this.localisation;
    }

    public int getNiveauImportance() {
        return this.niveau_importance;
    }

    public abstract String getType();

    public abstract String getDetails();
}

import java.util.ArrayList;

/**********************************************************************/
/*      Classe abstraite pour les moniteurs                           */
/**********************************************************************/

public abstract class Moniteur implements AnomalieListener{
    protected String nom;
    protected ArrayList<AnomalieEvent> anomalies = new ArrayList<AnomalieEvent>();

    public Moniteur(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return "Moniteur [nom=" + this.nom + "]";
    }

    public abstract String getType();

    public String getNom() {
        return this.nom;
    }

    public void nouvelleAnomalie(AnomalieEvent anomalie){
        System.out.println("\u001B[38;5;34mAnomalie détectée pour " + this.nom + " :\n  ->\t" + anomalie.toString() + "\u001B[0m\n");
        this.anomalies.add(anomalie);
    }

    public void aucuneAnomalie(){
        System.out.println("\u001B[38;5;124mAucune anomalie détectée pour "+ this.nom +"\u001B[0m\n");
    }

    public void traiterAnomalie(AnomalieEvent anomalie){
        System.out.println("\u001B[38;5;34mTraitement de l'anomalie " + this.nom + " :\n  ->\t" + anomalie.toString() + "\u001B[0m\n");
        this.anomalies.remove(anomalie);
    }
}
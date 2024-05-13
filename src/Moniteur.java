public abstract class Moniteur implements AnomalieListener{
    protected String nom;

    public Moniteur(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return "Moniteur [nom=" + this.nom + "]";
    }

    public abstract String getType();

    public void nouvelleAnomalie(AnomalieEvent anomalie){
        System.out.println("\u001B[38;5;34mAnomalie détectée pour " + this.nom + " :\n  ->\t" + anomalie.toString() + "\u001B[0m\n");
    }

    public void aucuneAnomalie(){
        System.out.println("\u001B[38;5;124mAucune anomalie détectée pour "+ this.nom +"\u001B[0m\n");
    }
}
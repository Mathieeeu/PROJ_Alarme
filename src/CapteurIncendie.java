public class CapteurIncendie extends Capteur {
    private boolean feu;

    public CapteurIncendie(String nom, String localisation, boolean feu) {
        super(nom, localisation);
        this.feu = feu;
    }

    public String toString() {
        return "CapteurIncendie [nom=" + super.nom + ", localisation=" + this.localisation + "]";
    }

    public void setFeu(boolean feu) {
        this.feu = feu;
        detecterAnomalie();
    }

    public void detecterAnomalie() {
        if (this.feu) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            System.out.print("Entrez la date de l'incendie : ");
            String date = System.console().readLine(); 
            System.out.print("Entrez le niveau d'importance de l'anomalie (1, 2 ou 3) : ");
            int niveau_importance = Integer.parseInt(System.console().readLine());
            System.out.println("\n");
            IncendieEvent event = new IncendieEvent(this, date, this.localisation, niveau_importance);
            for (AnomalieListener listener : listerners){
                listener.nouvelleAnomalie(event);
            }
        }
        else {
            for (AnomalieListener listener : listerners){
                listener.aucuneAnomalie();
            }
        }
    }
}
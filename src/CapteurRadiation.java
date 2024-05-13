public class CapteurRadiation extends Capteur{
    private int niveau_radiation;
    private int max_niveau_radiation;
    public CapteurRadiation(String nom, String localisation) {
        super(nom, localisation);
    }

    public String toString() {
        return "CapteurRadiation [nom=" + super.nom + ", localisation=" + this.localisation + "]";
    }

    public void setNiveauRadiation(int niveau_radiation) {
        this.niveau_radiation = niveau_radiation;
        detecterAnomalie();
    }

    public void detecterAnomalie() {
        if (this.niveau_radiation >= this.max_niveau_radiation) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            System.out.print("Entrez la date de la fuite de radiation : ");
            String date = System.console().readLine(); 
            System.out.print("Entrez le niveau d'importance de l'anomalie (1, 2 ou 3) : ");
            int niveau_importance = Integer.parseInt(System.console().readLine());
            System.out.println("\n");
            RadiationEvent event = new RadiationEvent(this, date, this.localisation, niveau_importance, this.niveau_radiation);
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

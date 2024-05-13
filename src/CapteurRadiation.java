public class CapteurRadiation extends Capteur{
    private int niveau_radiation;
    private int seuil_niveau_radiation;
    public CapteurRadiation(String nom, String localisation) {
        super(nom, localisation);
        this.niveau_radiation = 0;
        this.seuil_niveau_radiation = 10;
    }

    public String toString() {
        return "CapteurRadiation [nom=" + super.nom + ", localisation=" + this.localisation + ", niveau_radiation=" + this.niveau_radiation + "/" + this.seuil_niveau_radiation + "]";
    }

    public void setNiveauRadiation(int niveau_radiation) {
        this.niveau_radiation = niveau_radiation;
        detecterAnomalie();
    }

    public void detecterAnomalie() {
        if (this.niveau_radiation >= this.seuil_niveau_radiation) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            System.out.print("Entrez la date de la fuite de radiation : ");
            String date = System.console().readLine(); 
            System.out.print("Entrez le niveau d'importance de l'anomalie (1, 2 ou 3) : ");
            int niveau_importance = Integer.parseInt(System.console().readLine());
            System.out.println("\n");
            RadiationEvent event = new RadiationEvent(this, date, this.localisation, niveau_importance, this.niveau_radiation);
            for (AnomalieListener listener : listeners){
                listener.nouvelleAnomalie(event);
            }
        }
        else {
            for (AnomalieListener listener : listeners){
                listener.aucuneAnomalie();
            }
        }
    }
}

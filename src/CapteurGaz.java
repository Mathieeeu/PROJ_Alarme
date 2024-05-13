public class CapteurGaz extends Capteur {
    private String type;
    private int niveau_gaz;
    private int max_niveau_gaz;

    public CapteurGaz(String nom, String localisation, String type, int niveau_gaz, int max_niveau_gaz) {
        super(nom,localisation);
        this.type = type;
        this.niveau_gaz = niveau_gaz;
        this.max_niveau_gaz = max_niveau_gaz;
    }

    public String toString() {
        return "CapteurGaz [nom=" + super.nom + ", localisation=" + this.localisation + ", type=" + this.type + ", niveau_gaz=" + this.niveau_gaz + "/" + this.max_niveau_gaz + "]";
    }

    public void setGaz(int niveau_gaz, String type) {
        this.niveau_gaz = niveau_gaz;
        this.type = type;
        detecterAnomalie();
    }

    public void detecterAnomalie() {
        if (this.niveau_gaz >= this.max_niveau_gaz) {
            System.out.println("\u001B[38;5;54mAnomalie trouvée !\u001B[0m");
            System.out.print("Entrez la date de la fuite de gaz : ");
            String date = System.console().readLine(); 
            System.out.print("Entrez le niveau d'importance de l'anomalie (1, 2 ou 3) : ");
            int niveau_importance = Integer.parseInt(System.console().readLine());
            System.out.println("\n");
            GazEvent event = new GazEvent(this, date, this.localisation, niveau_importance, this.type);
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

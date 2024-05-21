public class Global {

    // Création des capteurs
    public static CapteurGaz capteur_gazA = new CapteurGaz("Capteur de gaz", "Batiment A", "CO2", 0, 100);
    public static CapteurGaz capteur_gazB = new CapteurGaz("Capteur de gaz", "Batiment B", "CO2", 0, 100);
    public static CapteurGaz capteur_gazC = new CapteurGaz("Capteur de gaz", "Batiment C", "CO2", 0, 100);
    public static CapteurIncendie capteur_incendieA = new CapteurIncendie("Capteur d'incendie", "Batiment A", false);
    public static CapteurIncendie capteur_incendieB = new CapteurIncendie("Capteur d'incendie", "Batiment B", false);
    public static CapteurIncendie capteur_incendieC = new CapteurIncendie("Capteur d'incendie", "Batiment C", false);
    public static CapteurRadiation capteur_radiationA = new CapteurRadiation("Capteur de radiation", "Batiment A");
    public static CapteurRadiation capteur_radiationB = new CapteurRadiation("Capteur de radiation", "Batiment B");
    public static CapteurRadiation capteur_radiationC = new CapteurRadiation("Capteur de radiation", "Batiment C");

    // Création des moniteurs
    public static Moniteur moniteurA = new MoniteurA("Moniteur A");
    public static Moniteur moniteurB = new MoniteurB("Moniteur B");

    // Ajout des moniteurs aux capteurs
    public static void AffecterCapteurMoniteur() {
        capteur_gazA.addAnomalieListener(moniteurA);
        capteur_gazB.addAnomalieListener(moniteurA);
        capteur_gazC.addAnomalieListener(moniteurA);
        capteur_incendieA.addAnomalieListener(moniteurA);
        capteur_incendieB.addAnomalieListener(moniteurA);
        capteur_incendieC.addAnomalieListener(moniteurA);
        capteur_gazA.addAnomalieListener(moniteurB);
        capteur_gazB.addAnomalieListener(moniteurB);
        capteur_gazC.addAnomalieListener(moniteurB);
        capteur_radiationA.addAnomalieListener(moniteurB);
        capteur_radiationB.addAnomalieListener(moniteurB);
        capteur_radiationC.addAnomalieListener(moniteurB);
    }

}

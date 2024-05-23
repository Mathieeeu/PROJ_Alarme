import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //Global.AffecterCapteurMoniteur();

        // Création des capteurs
        ArrayList<CapteurGaz> capteurs_gaz = new ArrayList<CapteurGaz>();
        ArrayList<CapteurIncendie> capteurs_incendie = new ArrayList<CapteurIncendie>();
        ArrayList<CapteurRadiation> capteurs_radiation = new ArrayList<CapteurRadiation>();
        capteurs_gaz.add(new CapteurGaz("Capteur de gaz", "Batiment A", "CO2", 0, 100));
        capteurs_gaz.add(new CapteurGaz("Capteur de gaz", "Batiment B", "CO2", 0, 100));
        capteurs_gaz.add(new CapteurGaz("Capteur de gaz", "Batiment C", "CO2", 0, 100));
        capteurs_incendie.add(new CapteurIncendie("Capteur d'incendie", "Batiment A", false));
        capteurs_incendie.add(new CapteurIncendie("Capteur d'incendie", "Batiment B", false));
        capteurs_incendie.add(new CapteurIncendie("Capteur d'incendie", "Batiment C", false));
        capteurs_radiation.add(new CapteurRadiation("Capteur de radiation", "Batiment A"));
        capteurs_radiation.add(new CapteurRadiation("Capteur de radiation", "Batiment B"));
        capteurs_radiation.add(new CapteurRadiation("Capteur de radiation", "Batiment C"));

        // Création des moniteurs
        ArrayList<Moniteur> moniteurs = new ArrayList<Moniteur>();
        moniteurs.add(new MoniteurA("Moniteur A"));
        moniteurs.add(new MoniteurB("Moniteur B"));

        // Ajout des moniteurs aux capteurs
        capteurs_gaz.get(0).addAnomalieListener(moniteurs.get(0));
        capteurs_gaz.get(1).addAnomalieListener(moniteurs.get(0));
        capteurs_gaz.get(2).addAnomalieListener(moniteurs.get(0));
        capteurs_incendie.get(0).addAnomalieListener(moniteurs.get(0));
        capteurs_incendie.get(1).addAnomalieListener(moniteurs.get(0));
        capteurs_incendie.get(2).addAnomalieListener(moniteurs.get(0));
        capteurs_gaz.get(0).addAnomalieListener(moniteurs.get(1));
        capteurs_gaz.get(1).addAnomalieListener(moniteurs.get(1));
        capteurs_gaz.get(2).addAnomalieListener(moniteurs.get(1));
        capteurs_radiation.get(0).addAnomalieListener(moniteurs.get(1));
        capteurs_radiation.get(1).addAnomalieListener(moniteurs.get(1));
        capteurs_radiation.get(2).addAnomalieListener(moniteurs.get(1));

        // Création des fenêtres
        FenetreAlarme fenetre = new FenetreAlarme(capteurs_gaz, capteurs_incendie, capteurs_radiation);
        FenetreMoniteur fenetre_moniteur = new FenetreMoniteur(moniteurs);
    }
}
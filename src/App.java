public class App {
    public static void main(String[] args) throws Exception {

        CapteurGaz capteur_gaz = new CapteurGaz("Capteur de gaz", "Salle de bain", "CO2", 0, 100);
        CapteurGaz capteur_gaz2 = new CapteurGaz("Capteur de gaz", "Cuisine", "CO2", 0, 100);
        CapteurIncendie capteur_incendie = new CapteurIncendie("Capteur d'incendie", "Salon", false);
        Moniteur moniteurA = new MoniteurA("Moniteur A");
        Moniteur moniteurB = new MoniteurB("Moniteur B");

        capteur_gaz.addAnomalieListener(moniteurA);
        capteur_gaz.addAnomalieListener(moniteurB);
        capteur_gaz2.addAnomalieListener(moniteurA);
        capteur_incendie.addAnomalieListener(moniteurB);

        System.out.println("Capteur de gaz 1 : " + capteur_gaz.toString());
        System.out.println("\n");
        System.out.println("Niveau de gaz à 50/100 :");
        capteur_gaz.setGaz(50,"CO2");
        System.out.println("\n");
        System.out.println("Niveau de gaz à 150/100 :");
        capteur_gaz.setGaz(150,"CO2");

        System.out.println("Capteur de gaz 2 : " + capteur_gaz2.toString());
        System.out.println("\n");
        System.out.println("Niveau de gaz à 50/100 :");
        capteur_gaz2.setGaz(50,"CO2");
        System.out.println("\n");
        System.out.println("Niveau de gaz à 150/100 :");
        capteur_gaz2.setGaz(150,"CO2");

        System.out.println("Capteur d'incendie : " + capteur_incendie.toString());
        System.out.println("\n");
        System.out.println("Feu : false");
        capteur_incendie.setFeu(false);
        System.out.println("\n");
        System.out.println("Feu : true");
        capteur_incendie.setFeu(true);
    }
}
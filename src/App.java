public class App {
    public static void main(String[] args) throws Exception {
        Global.AffecterCapteurMoniteur();
        FenetreAlarme fenetre = new FenetreAlarme();
        FenetreMoniteur fenetre_moniteur = new FenetreMoniteur();
    }
}
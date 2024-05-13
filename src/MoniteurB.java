public class MoniteurB extends Moniteur {
    // Moniteur de type B = anomalie de type gaz ou radiations
    public MoniteurB(String nom) {
        super(nom);
    }

    public String toString() {
        return "MoniteurB [nom=" + super.nom + "]";
    }

    public String getType(){
        return "B";
    }
}

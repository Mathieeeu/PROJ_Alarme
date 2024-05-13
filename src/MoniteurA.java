public class MoniteurA extends Moniteur {
    // Moniteur de type A = anomalie de type incendie ou gaz
    public MoniteurA(String nom) {
        super(nom);
    }

    public String toString() {
        return "MoniteurA [nom=" + super.nom + "]";
    }
}

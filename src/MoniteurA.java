/**********************************************************************/
/*         Classe pour les moniteurs de type A (incendie et gaz)      */
/**********************************************************************/

public class MoniteurA extends Moniteur {
    public MoniteurA(String nom) {
        super(nom);
    }

    public String getType(){
        return "A";
    }

    public String toString() {
        return "MoniteurA [nom=" + super.nom + "]";
    }
}

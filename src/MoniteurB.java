/**********************************************************************/
/*       Classe pour les moniteurs de type A (gaz et radiations)      */
/**********************************************************************/

public class MoniteurB extends Moniteur {
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

import java.util.EventListener;

/**********************************************************************/
/*      Interface pour les écouteurs des événements d'anomalies       */
/**********************************************************************/

public interface AnomalieListener extends EventListener {
    public void nouvelleAnomalie(AnomalieEvent anomalie);
    public void aucuneAnomalie();
}

import java.util.EventListener;

public interface AnomalieListener extends EventListener {
    public void nouvelleAnomalie(AnomalieEvent anomalie);
    public void aucuneAnomalie();
}

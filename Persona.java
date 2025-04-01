import java.util.Random;

public class Persona {
    private static int idCounter = 1; 
    private int id;
    private int pianoDestinazione;

    public Persona(int pianoCorrente) {
        this.id = idCounter++;
        Random rand = new Random();
        do {
            this.pianoDestinazione = rand.nextInt(10) + 1; // Piano tra 1 e 10
        } while (this.pianoDestinazione == pianoCorrente); // Evita stesso piano
    }

    public int getPianoDestinazione() {
        return pianoDestinazione;
    }

    public void saliSuAscensore(Ascensore ascensore) {
        if (ascensore.isPorteAperte()) {
            ascensore.aggiungiPersona(this);
        }
    }

    @Override
    public String toString() {
        return "Persona " + id + " -> Piano " + pianoDestinazione;
    }
}

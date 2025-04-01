import java.util.ArrayList;

public class Ascensore {
    private int pianoCorrente;
    private final int capienzaMassima;
    private boolean porteAperte;
    private ArrayList<Persona> personeDentro;

    public Ascensore(int capienzaMassima) {
        this.pianoCorrente = 1; // Parte dal piano terra
        this.capienzaMassima = capienzaMassima;
        this.personeDentro = new ArrayList<>();
        this.porteAperte = false;
    }

    public int getPianoCorrente() {
        return pianoCorrente;
    }

    public void apriPorte() {
        porteAperte = true;
    }

    public void chiudiPorte() {
        porteAperte = false;
    }

    public boolean isPorteAperte() {
        return porteAperte;
    }

    public void aggiungiPersona(Persona p) {
        if (porteAperte && personeDentro.size() < capienzaMassima) {
            personeDentro.add(p);
            System.out.println("Persona aggiunta: " + p);
        }
    }

    public void rimuoviPersoneArrivate() {
        personeDentro.removeIf(p -> p.getPianoDestinazione() == pianoCorrente);
    }

    public void salita() {
        if (pianoCorrente < 10) {
            pianoCorrente++;
        }
    }

    public void discesa() {
        if (pianoCorrente > 1) {
            pianoCorrente--;
        }
    }

    @Override
    public String toString() {
        return "Ascensore al piano " + pianoCorrente + " con " + personeDentro.size() + " persone dentro.";
    }
}

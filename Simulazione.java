public class Simulazione {
    public static void main(String[] args) {
        Ascensore ascensore = new Ascensore(4); // Ascensore con 4 posti
        Piano[] piani = new Piano[10];

        // Creazione dei piani
        for (int i = 0; i < 10; i++) {
            piani[i] = new Piano(i + 1);
            piani[i].aggiungiPersonaCoda(); // Aggiunge una persona a ogni piano
        }

        // Simulazione di 10 step di movimento dell'ascensore
        for (int i = 0; i < 10; i++) {
            System.out.println(ascensore);
            
            // L'ascensore apre le porte al piano attuale
            ascensore.apriPorte();
            
            // Le persone in coda provano a salire
            Persona p = piani[ascensore.getPianoCorrente() - 1].rimuoviPersonaCoda();
            if (p != null) {
                ascensore.aggiungiPersona(p);
            }

            // Le persone arrivano a destinazione ed escono
            ascensore.rimuoviPersoneArrivate();

            // Chiude le porte e decide la direzione
            ascensore.chiudiPorte();
            ascensore.salita(); // Per ora solo salita
        }
    }
}

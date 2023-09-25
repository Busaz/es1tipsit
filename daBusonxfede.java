import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private int matricola;
    private String corsoDiStudi;
    private float[] voti = new float[10];
    private int numVotiInseriti;

    public Studente(String nome, String cognome, String dataDiNascita, int matricola, String corsoDiStudi) throws ParseException {
        this.nome = nome;
        this.cognome = cognome;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataDiNascita = sdf.parse(dataDiNascita);
        this.matricola = matricola;
        this.corsoDiStudi = corsoDiStudi;
        this.numVotiInseriti = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getCorsoDiStudi() {
        return corsoDiStudi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setCorsoDiStudi(String corsoDiStudi) {
        this.corsoDiStudi = corsoDiStudi;
    }

    public void aggiungiVoto(float voto) {
        if (numVotiInseriti < 10) {
            voti[numVotiInseriti] = voto;
            numVotiInseriti++;
        } else {
            System.out.println("Impossibile aggiungere ulteriori voti. Numero massimo di voti raggiunto.");
        }
    }

    public void rimuoviVoti() {
        for (int i = 0; i < 10; i++) {
            voti[i] = 0.0f;
        }
        numVotiInseriti = 0;
    }

    public void stampaInformazioni() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data di nascita: " + sdf.format(dataDiNascita));
        System.out.println("Matricola: " + matricola);
        System.out.println("Corso di studi: " + corsoDiStudi);
        System.out.print("Voti: ");
        for (int i = 0; i < numVotiInseriti; i++) {
            System.out.print(voti[i] + " ");
        }
        System.out.println();
    }

    public float calcolaMediaVoti() {
        if (numVotiInseriti == 0) {
            return 0.0f;
        }
        float somma = 0;
        for (int i = 0; i < numVotiInseriti; i++) {
            somma += voti[i];
        }
        return somma / numVotiInseriti;
    }

    public int calcolaEta() {
        Date oggi = new Date();
        long differenzaInMillisecondi = oggi.getTime() - dataDiNascita.getTime();
        long anni = differenzaInMillisecondi / (1000L * 60 * 60 * 24 * 365);
        return (int) anni;
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        // Creazione di due oggetti Studente con dati di esempio
        Studente studente1 = new Studente("Mario", "Rossi", "10/05/1998", 123456, "Ingegneria");
        Studente studente2 = new Studente("Laura", "Bianchi", "25/09/2000", 789012, "Informatica");

        // Assegnazione di voti agli studenti
        studente1.aggiungiVoto(27);
        studente1.aggiungiVoto(30);
        studente1.aggiungiVoto(25);
        studente2.aggiungiVoto(28);
        studente2.aggiungiVoto(29);
        studente2.aggiungiVoto(26);

        // Stampa delle informazioni sugli studenti e calcolo della media dei voti
        studente1.stampaInformazioni();
        System.out.println("Media voti studente 1: " + studente1.calcolaMediaVoti());
        System.out.println("Età studente 1: " + studente1.calcolaEta() + " anni");

        System.out.println();

        studente2.stampaInformazioni();
        System.out.println("Media voti studente 2: " + studente2.calcolaMediaVoti());
        System.out.println("Età studente 2: " + studente2.calcolaEta() + " anni");
    }
}
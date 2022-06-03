package persoana;

import org.testng.annotations.Test;

public class Persoana {
    private String nume;
    private String prenume;
    private long cnp;
    private int varsta;

    public Persoana(){}

    public Persoana(String nume, String prenume, long cnp, int varsta){
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Test
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public long getCnp() {
        return cnp;
    }

    @Test
    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Test
    public static String greeting() {
        return String.format("Hello!");
    }

    @Test
    public static String met2() {
        return String.format("Asta e o metoda statica");
    }


    @Override
    public String toString() {
        return "persoana.Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp=" + cnp +
                ", varsta=" + varsta +
                '}';
    }
}

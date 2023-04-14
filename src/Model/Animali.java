package Model;

public class Animali {
    private int id;
    private String specie;
    private String soprannome;
    private boolean adottatp;
    private boolean pericolo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getSoprannome() {
        return soprannome;
    }

    public void setSoprannome(String soprannome) {
        this.soprannome = soprannome;
    }
}

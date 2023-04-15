package Model;

public class Animal {
    private int id;
    private String species;
    private String nickname;
    private boolean adopt;
    private boolean inDanger;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecie() {
        return species;
    }

    public void setSpecie(String specie) {
        this.species = specie;
    }

    public String getSoprannome() {
        return nickname;
    }

    public void setSoprannome(String soprannome) {
        this.nickname = soprannome;
    }
}
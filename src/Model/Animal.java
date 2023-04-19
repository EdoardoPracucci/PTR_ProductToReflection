package Model;

public class Animal {
    private int id;
    private String species;
    private String nickname;
    private boolean adopt;
    private boolean inDanger;

    public Animal() {
        this.id = 0;
        this.species = null;
        this.nickname = null;
        this.adopt = false;
        this.inDanger = false;
    }

    public Animal(int id, String species, String nickname, boolean adopt, boolean inDanger) {
        this.id = id;
        this.species = species;
        this.nickname = nickname;
        this.adopt = adopt;
        this.inDanger = inDanger;
    }

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

    @Override
    public String toString() {
        return "( " +
                id +
                " , " + species +
                " , " + nickname +
                " , " + adopt +
                " , " + inDanger +
                ")";
    }
}

package Model;

import java.util.HashMap;
import java.util.Map;

public class Animal implements BaseRepositoryCompatibleModel{
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

    public String getSpecies() {
        return species;
    }

    public void setSpecie(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public boolean isAdopt() {
        return adopt;
    }

    public void setAdopt(boolean adopt) {
        this.adopt = adopt;
    }

    public boolean isInDanger() {
        return inDanger;
    }

    public void setInDanger(boolean inDanger) {
        this.inDanger = inDanger;
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
    public Map<String, Object> getAllAttributesValue(){
        Map<String,Object> valuesAttributes=new HashMap<>();
        valuesAttributes.put("id",getId());
        valuesAttributes.put("species",getSpecies());
        valuesAttributes.put("nickname",getNickname());
        valuesAttributes.put("adopt",isAdopt());
        valuesAttributes.put("inDanger",isInDanger());
        return valuesAttributes;
    }
}

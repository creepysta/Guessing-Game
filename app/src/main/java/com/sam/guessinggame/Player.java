package com.sam.guessinggame;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Player extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private String password;
    private int recent_score_animal = 0;
    private int max_score_animal = 0;
    private int recent_score_flower = 0;
    private int max_score_flower = 0;
    private int max_score = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRecent_score_animal() {
        return recent_score_animal;
    }

    public void setRecent_score_animal(int recent_score_animal) {
        this.recent_score_animal = recent_score_animal;
    }

    public int getMax_score_animal() {
        return max_score_animal;
    }

    public void setMax_score_animal(int max_score_animal) {
        this.max_score_animal = max_score_animal;
    }

    public int getRecent_score_flower() {
        return recent_score_flower;
    }

    public void setRecent_score_flower(int recent_score_flower) {
        this.recent_score_flower = recent_score_flower;
    }

    public int getMax_score_flower() {
        return max_score_flower;
    }

    public void setMax_score_flower(int max_score_flower) {
        this.max_score_flower = max_score_flower;
    }

    public int getMax_score() {
        return max_score;
    }

    public void setMax_score(int max_score) {
        this.max_score = max_score;
    }
}

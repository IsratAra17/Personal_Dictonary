package com.example.personal_dictonary.ModelClass;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dictionary")
public class ModelDictionary {


    @PrimaryKey(autoGenerate = true)
    public int id;
    public String word;
    public String mean;

    public ModelDictionary(String word, String mean)
    {

    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public ModelDictionary(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

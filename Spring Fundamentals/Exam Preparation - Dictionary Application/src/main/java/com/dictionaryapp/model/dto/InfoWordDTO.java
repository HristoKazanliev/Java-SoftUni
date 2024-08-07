package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class InfoWordDTO {
    private long id;
    private String term;
    private String translation;
    private String example;
    private String username;
    private LocalDate inputDate;

    public InfoWordDTO(Word word) {
        this.id = word.getId();
        this.term = word.getTerm();
        this.translation = word.getTranslation();
        this.example = word.getExample();
        this.username = word.getAddedBy().getUsername();
        this.inputDate = word.getInputDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}

package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.enums.LanguageEnum;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddWordDTO {
    private Long id;

    @NotBlank
    @Size(min = 2, max = 40)
    private String term;

    @NotBlank
    @Size(min = 2, max = 80)
    private String translation;

    @NotBlank
    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    @PastOrPresent(message = "Enter valid date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate inputDate;

    @NotNull
    private LanguageEnum language;

    public AddWordDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }
}

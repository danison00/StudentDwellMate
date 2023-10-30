package com.dan.StudentDwellMate.model.entities;

import lombok.Getter;

@Getter
public enum Occupation {

    STUDENT("Estudante"), OTHER("Outro");


    private final String occupation;

    Occupation(String occupation) {
        this.occupation = occupation;
    }
}

package com.stuxnet.education.elevenplusexam.constants;

/**
 * Created by pankajpardasani on 22/05/2017.
 */
public enum ElevenPlusExamEnum {
    STUDENT("Student"), PERFORMANCE("Performance"), SCHOOL("School");

    private final String value;

    ElevenPlusExamEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

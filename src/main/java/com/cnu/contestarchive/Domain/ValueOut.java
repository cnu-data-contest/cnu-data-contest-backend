package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class ValueOut {
    ValueIn[] intern;
    ValueIn[] contest;
    ValueIn[] seminar;

    public ValueOut(ValueIn[] intern, ValueIn[] contest, ValueIn[] seminar) {
        this.intern = intern;
        this.contest = contest;
        this.seminar = seminar;
    }
}

package com.example.jobhunt.model;

public enum Location {
    Hanoi("Ha Noi"),Haiphong("Hai Phong"),Danang("Da Nang"),Hochiminh("Ho Chi Minh");

    private String value;

    Location(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value ;
    }
}

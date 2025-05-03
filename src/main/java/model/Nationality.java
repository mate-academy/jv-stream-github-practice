package model;

public enum Nationality {
    UKR("Ukrainian");

    private final String value;

    Nationality(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

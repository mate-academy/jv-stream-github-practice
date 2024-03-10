package model;

public enum Nationality {
    UA("Ukrainian"),
    UK("British"),
    FR("French"),
    PL("Polish");

    private final String name;

    Nationality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

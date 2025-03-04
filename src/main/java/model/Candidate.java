package model;

import java.util.Objects;

public class Candidate {
    private  int age;
    private  String nationality;
    private  boolean allowedToVote;
    private  String periodsInUkr;
    private String name;

    public Candidate(int age, String nationality, boolean allowedToVote, String periodsInUkr) {
        this.age = age;
        this.nationality = nationality;
        this.allowedToVote = allowedToVote;
        this.periodsInUkr = periodsInUkr;

    }

    public static int getAge() {
        return age;
    }

    public static String getNationality() {
        return nationality;
    }

    public static boolean isAllowedToVote() {
        return allowedToVote;
    }

    public static String getPeriodsInUkr() {
        return periodsInUkr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true && Objects.equals(periodsInUkr, periodsInUkr) && Objects.equals(name, candidate.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getNationality(),
            isAllowedToVote(), getPeriodsInUkr(), getName());
    }
}

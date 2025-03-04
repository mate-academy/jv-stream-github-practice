package model;

import java.util.Objects;

public class Candidate {
    private static int age;
    private static String nationality;
    private static boolean allowedToVote;
    private static String periodsInUkr;
    private String name;

    public Candidate(int age, String nationality, boolean allowedToVote, String periodsInUkr) {
        Candidate.age = age;
        Candidate.nationality = nationality;
        Candidate.allowedToVote = allowedToVote;
        Candidate.periodsInUkr = periodsInUkr;

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
        Candidate candidate = (Candidate) o;
        return allowedToVote == allowedToVote && Objects.equals(nationality, nationality) && Objects.equals(periodsInUkr, periodsInUkr) && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getNationality(),
            isAllowedToVote(), getPeriodsInUkr(), getName());
    }
}

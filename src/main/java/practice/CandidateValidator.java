package practice;

import model.Candidate;

import java.util.List;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        boolean livedInUkraineFor10Years = calculateTotalYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;

        return age >= 35 && allowedToVote && nationality.equals("Ukrainian") && livedInUkraineFor10Years;
    }

    private int calculateTotalYearsInUkraine(String periodsInUkraine) {
        String[] periods = periodsInUkraine.split(",");
        int totalYears = 0;
        for (String period: periods) {
            String[] years = period.split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            totalYears += endYear - startYear + 1;
        }
        return totalYears;
    }
}

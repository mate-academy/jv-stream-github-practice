package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        boolean livedInUkraineFor10Years =
                calculateTotalYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;

        return age >= MIN_AGE
                && allowedToVote
                && nationality.equals("Ukrainian")
                && livedInUkraineFor10Years;
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

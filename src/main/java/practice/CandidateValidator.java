package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_AGE = 35;
    static final int MIN_YEARS_IN_UKRAINE = 10;
    static final String NATIONALITY_NEEDED = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = calculateYearsInUkraine(candidate.getPeriodsInUkr());

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_NEEDED)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String periodsInUkraine) {
        int totalYears = 0;
        String[] periods = periodsInUkraine.split(",");

        for (String period : periods) {
            String[] years = period.trim().split("-");
            if (years.length == 2) {
                try {
                    int startYear = Integer.parseInt(years[0].trim());
                    int endYear = Integer.parseInt(years[1].trim());
                    totalYears += endYear - startYear;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format in period '" + period + "'");
                }
            } else {
                System.err.println("Unexpected format in period '" + period + "'");
            }
        }
        return totalYears;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String UKRAINIAN_NATIONALITY = "Ukraininan";
    public static final String DELIMITER = "-";
    public static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && getPeriodsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean getPeriodsInUkr(String periods) {
        String[] years = periods.split(DELIMITER);
        if (years.length == 2) {
            try {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                return (endYear - startYear) >= REQUIRED_YEARS_IN_UKRAINE;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}

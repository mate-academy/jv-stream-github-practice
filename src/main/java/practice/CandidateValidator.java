package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isEligibleForPresident(candidate);
    }

    private static boolean isEligibleForPresident(Candidate candidate) {
        CandidateValidator validator = new CandidateValidator();

        int totalYearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .mapToInt(validator::calculateYearsInUkraine)
                .sum();

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && totalYearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsInUkraine(String period) {
        String[] years = period.split(SEPARATOR);
        int startYear = Integer.parseInt(years[START_PERIOD]);
        int endYear = Integer.parseInt(years[END_PERIOD]);
        return endYear - startYear + 1;
    }
}

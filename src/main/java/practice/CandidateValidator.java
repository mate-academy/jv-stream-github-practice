package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = ",";
    private static final String YEAR_SEPARATOR = "-";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && Arrays.stream(candidate.getPeriodsInUkr()
                        .split(PERIOD_SEPARATOR))
                .anyMatch(period -> {
                    String[] years = period.split(YEAR_SEPARATOR);
                    int startYear = Integer.parseInt(years[0]);
                    int endYear = Integer.parseInt(years[1]);
                    return endYear - startYear >= MIN_YEARS_IN_UKRAINE;
                });
    }
}

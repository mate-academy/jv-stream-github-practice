package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINE_CITIZEN = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_INDEX_OF_FIRST_YEAR = 0;
    private static final int START_INDEX_OF_SECOND_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && calculateNumberOfYearsInUkraine(candidate) > MIN_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_CITIZEN);
    }

    private static int calculateNumberOfYearsInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf(SEPARATOR)
                        + START_INDEX_OF_SECOND_YEAR))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(START_INDEX_OF_FIRST_YEAR,
                        candidate.getPeriodsInUkr().indexOf(SEPARATOR)));
    }
}

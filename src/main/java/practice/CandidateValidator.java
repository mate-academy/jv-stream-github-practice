package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int VALID_YEAR_NUMBER = 10;
    private static final String SPLIT_SYMBOL = "-";
    private static final int MIN_AGE_FOR_PRESIDENT_POSITION = 35;
    private static final int INDEX_OF_START_OF_PERIOD = 0;
    private static final int INDEX_OF_END_OF_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT_POSITION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && periodIsValid(candidate);
    }

    private static boolean periodIsValid(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        return Integer.parseInt(years[INDEX_OF_END_OF_PERIOD])
                - Integer.parseInt(years[INDEX_OF_START_OF_PERIOD]) >= VALID_YEAR_NUMBER;
    }
}

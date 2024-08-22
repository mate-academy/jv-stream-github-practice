package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONAL = "Ukrainian";
    private static final String SPLIT_VALUE = "-";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int MIN_PERIODS = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONAL)) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split(SPLIT_VALUE);
        int startYear = Integer.parseInt(periods[START_INDEX]);
        int endYear = Integer.parseInt(periods[END_INDEX]);
        return endYear - startYear >= MIN_PERIODS;
    }
}

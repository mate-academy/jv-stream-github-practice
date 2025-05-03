package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_AGE_OF_CANDIDATE = 35;
    private static final String SPLIT_DELIMITER = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split(SPLIT_DELIMITER)[ONE])
                - Integer.parseInt(candidate.getPeriodsInUkr().split(SPLIT_DELIMITER)[ZERO])
                >= MIN_PERIOD_IN_UKRAINE && candidate.getAge() >= MIN_AGE_OF_CANDIDATE
                && candidate.isAllowedToVote() && candidate.getNationality().equals(NATIONALITY);
    }
}

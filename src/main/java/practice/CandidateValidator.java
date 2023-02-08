package practice;

import java.util.function.Predicate;

import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE = 10;
    private static final String PERIOD_SEPARATOR = "-";
    private static final int PERIOD_START_YEAR = 0;
    private static final int PERIOD_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        final String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && (Integer.parseInt(periodInUkraine[PERIOD_END_YEAR])
                - (Integer.parseInt(periodInUkraine[PERIOD_START_YEAR])))
                >= REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE;
    }
}

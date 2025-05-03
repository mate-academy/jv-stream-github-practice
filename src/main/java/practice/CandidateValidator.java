package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final int VALID_PERIODS_IN_UKR = 10;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getTermInUkr(candidate.getPeriodsInUkr()) >= VALID_PERIODS_IN_UKR;
    }

    private static int getTermInUkr(String period) {
        String[] periods = period.split(SEPARATOR);
        return Integer.parseInt(periods[END_INDEX]) - Integer.parseInt(periods[START_INDEX]);
    }
}

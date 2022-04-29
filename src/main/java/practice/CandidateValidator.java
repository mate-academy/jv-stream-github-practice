package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_CANDIDATES_AGE = 35;
    private static final String CANDIDATES_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MAX_CANDIDATES_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATES_NATIONALITY)
                && Integer.parseInt(periodInUkr[END_YEAR_INDEX])
                - Integer.parseInt(periodInUkr[START_YEAR_INDEX]) >= MIN_PERIOD_IN_UKRAINE;
    }
}

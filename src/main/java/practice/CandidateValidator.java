package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final int START_INDEX_IN_UKRAINE = 0;
    private static final int LAST_INDEX_IN_UKRAINE = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && validCandidateFromUkraine(candidate);
    }

    private boolean validCandidateFromUkraine(Candidate candidate) {
        String[] periodsInUkrSplitted = candidate.getPeriodsInUkr().split(SEPARATOR);
        int lastYear = Integer.parseInt(periodsInUkrSplitted[LAST_INDEX_IN_UKRAINE]);
        int startYear = Integer.parseInt(periodsInUkrSplitted[START_INDEX_IN_UKRAINE]);
        return MIN_YEARS_LIVE_IN_UKRAINE <= (lastYear - startYear);
    }
}

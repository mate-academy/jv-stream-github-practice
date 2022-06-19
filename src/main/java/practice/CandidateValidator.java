package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int INDEX_YEAR_BEGINNING_IN_UKRAINE = 0;
    private static final int INDEX_YEAR_DEPARTURE_FROM_UKRAINE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dataPeriodsInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(dataPeriodsInUkr[INDEX_YEAR_DEPARTURE_FROM_UKRAINE])
                - Integer.parseInt(dataPeriodsInUkr[INDEX_YEAR_BEGINNING_IN_UKRAINE]))
                >= MIN_PERIOD_IN_UKRAINE;
    }
}

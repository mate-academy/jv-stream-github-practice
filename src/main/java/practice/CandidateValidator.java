package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_CANDIDATE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_TO])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_YEAR_FROM])
                >= PERIOD_IN_UKRAINE);
    }
}

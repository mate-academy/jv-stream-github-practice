package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_PERIODS = 10;
    private static final String NATIONALITY_UA = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UA)
                && Integer.parseInt(periodInUkr[INDEX_SECOND])
                    - Integer.parseInt(periodInUkr[INDEX_FIRST]) > MIN_PERIODS;
    }
}

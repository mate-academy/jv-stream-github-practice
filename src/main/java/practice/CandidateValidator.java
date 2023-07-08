package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;
    private static final int MIN_ALLOWED_YEARS = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String HYPHEN_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getAgesLivedInUkr(candidate) >= MIN_ALLOWED_YEARS;
    }

    private int getAgesLivedInUkr(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(HYPHEN_DELIMITER);
        int livesFrom = Integer.parseInt(periodInUkr[INDEX_PERIOD_FROM]);
        int livedTo = Integer.parseInt(periodInUkr[INDEX_PERIOD_TO]);
        return livedTo - livesFrom;
    }
}

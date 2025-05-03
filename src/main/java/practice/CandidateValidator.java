package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final int REQUIRED_AGE = 35;
    public static final int MIN_TIME_LIVE_IN_UA = 10;
    public static final boolean ALLOWED_TO_VOTE = true;
    public static final int INDEX_YEAR_FROM = 0;
    public static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUA = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= REQUIRED_AGE
                && Integer.parseInt(periodInUA[INDEX_YEAR_TO])
                - Integer.parseInt(periodInUA[INDEX_YEAR_FROM])
                >= MIN_TIME_LIVE_IN_UA
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE;
    }
}

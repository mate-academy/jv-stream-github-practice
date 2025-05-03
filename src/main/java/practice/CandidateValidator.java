package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final byte MIN_AGE = 35;
    private static final byte MIN_PERIOD_OF_RESIDENCE = 10;
    private static final byte YEAR_TO = 1;
    private static final byte YEAR_FROM = 0;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodsInUkr(candidate) >= MIN_PERIOD_OF_RESIDENCE;
    }

    private int getPeriodsInUkr(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(split[YEAR_TO]) - Integer.parseInt(split[YEAR_FROM]);
    }
}

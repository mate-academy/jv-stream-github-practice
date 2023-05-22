package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR = 10;
    private static final int PERIOD_TO = 1;
    private static final int PERIOD_FROM = 0;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsinUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && Integer.parseInt(periodsinUkraine[PERIOD_TO])
                - Integer.parseInt(periodsinUkraine[PERIOD_FROM])
                >= MIN_YEAR;
    }
}

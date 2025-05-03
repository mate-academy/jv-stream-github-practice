package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_COUNTRY = 10;
    private static final int FIRST_DATE_INDEX = 1;
    private static final int LAST_DATE_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(period[FIRST_DATE_INDEX])
                - Integer.parseInt(period[LAST_DATE_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= PERIOD_IN_COUNTRY;
    }
}

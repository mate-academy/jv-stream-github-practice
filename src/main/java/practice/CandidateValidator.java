package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_YEARS_IN_COUNTRY = 10;
    private static final int FIRST_DATE_INDEX = 1;
    private static final int LAST_DATE_INDEX = 0;

    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(period[FIRST_DATE_INDEX])
                - Integer.parseInt(period[LAST_DATE_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= PERIOD_YEARS_IN_COUNTRY;
    }
}

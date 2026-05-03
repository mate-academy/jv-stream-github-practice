package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate c) {
        int yearFrom = Integer.parseInt(c.getPeriodsInUkr().split("-")[0]);
        int yearTo = Integer.parseInt(c.getPeriodsInUkr().split("-")[1]);
        int yearsDiff = yearTo - yearFrom;

        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(NATIONALITY)
                && yearsDiff >= MIN_YEARS_IN_UKR;
    }
}

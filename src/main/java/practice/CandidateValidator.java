package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_LIVING_IN_UKRAINE = 10;
    private static final int DATE_FROM_INDEX = 0;
    private static final int DATE_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] datesFromTo = candidate.getPeriodsInUkr().split("-");
        int yearsLivedInUkraine = Integer.parseInt(datesFromTo[DATE_TO_INDEX])
                - Integer.parseInt(datesFromTo[DATE_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsLivedInUkraine >= MIN_YEARS_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

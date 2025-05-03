package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_COUNT_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int timeOfLifeInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= MIN_VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && timeOfLifeInUkraine >= MIN_COUNT_YEARS_IN_UKR;
    }
}

package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final int MIN_ALLOWED_YEARS = 10;
    private static final int MIN_ALLOWED_AGE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && Objects.equals(candidate.getNationality(), REQUIRED_NATIONALITY)
                && Integer.parseInt(periodInUkraine[YEAR_TO_INDEX])
                - Integer.parseInt(periodInUkraine[YEAR_FROM_INDEX]) >= MIN_ALLOWED_YEARS;
    }
}

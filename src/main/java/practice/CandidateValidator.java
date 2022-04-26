package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.getNationality().matches(VALID_NATIONALITY)
                && getPeriodsInUkraineSupplier(candidate);
    }

    private boolean getPeriodsInUkraineSupplier(Candidate candidate) {
        String[] dateArray = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(dateArray[1]) - Integer.parseInt(dateArray[0]))
                > MIN_YEARS_IN_UKRAINE;
    }
}

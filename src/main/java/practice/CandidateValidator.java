package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int BEGINNING_OF_LIVING_INDEX = 0;
    private static final int END_OF_LIVING_INDEX = 1;
    private static final int PERIOD_OF_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[END_OF_LIVING_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[BEGINNING_OF_LIVING_INDEX]) >= PERIOD_OF_LIVING;
    }
}

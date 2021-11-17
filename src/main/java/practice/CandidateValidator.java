package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ELIGIBLE_FOR_ELECTION_AGE = 35;
    private static final int MIN_YEARS_LIVED_IN_THE_STATE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int candidateYearsLivedInTheState = calculateYearsLivedInTheState(
                candidate.getPeriodsInUkr());
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidateYearsLivedInTheState >= MIN_YEARS_LIVED_IN_THE_STATE
                && candidate.getAge() >= MIN_ELIGIBLE_FOR_ELECTION_AGE
                && candidate.isAllowedToVote();
    }

    private int calculateYearsLivedInTheState(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("\\D"))
                .map(Integer::parseInt)
                .reduce((yearFrom, yearTo) -> yearTo - yearFrom)
                .orElse(0);
    }
}

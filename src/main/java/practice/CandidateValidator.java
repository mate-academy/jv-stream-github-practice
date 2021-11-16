package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_FOR_ELECTION_AGE = 35;
    private static final int YEARS_LIVED_IN_THE_STATE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int candidateYearsLivedInTheState = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidateYearsLivedInTheState >= YEARS_LIVED_IN_THE_STATE
                && candidate.getAge() >= ELIGIBLE_FOR_ELECTION_AGE
                && candidate.isAllowedToVote();
    }
}

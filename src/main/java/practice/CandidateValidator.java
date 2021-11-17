package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ELIGIBLE_FOR_ELECTION_AGE = 35;
    private static final int MIN_YEARS_LIVED_IN_THE_STATE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int candidateYearsLivedInTheState =
                Integer.parseInt(years[INDEX_ONE]) - Integer.parseInt(years[INDEX_ZERO]);
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidateYearsLivedInTheState >= MIN_YEARS_LIVED_IN_THE_STATE
                && candidate.getAge() >= MIN_ELIGIBLE_FOR_ELECTION_AGE
                && candidate.isAllowedToVote();
    }
}

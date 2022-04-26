package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE_OF_CANDIDATE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_YEARS_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return (candidate.getAge() >= VALID_AGE_OF_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && Integer.parseInt(years[1])
                - Integer.parseInt(years[0]) >= MIN_YEARS_LIVING);
    }
}

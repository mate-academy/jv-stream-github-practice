package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_TERM_OF_RESIDENCE = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearTo = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[YEAR_TO_INDEX]);
        int yearFrom = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote() && candidate.getNationality().equals(NATIONALITY)
                && yearTo - yearFrom > MIN_TERM_OF_RESIDENCE;
    }
}

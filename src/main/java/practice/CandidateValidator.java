package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_THE_CANDIDATE = 35;
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(period[YEAR_FROM_INDEX]);
        int yearTo = Integer.parseInt(period[YEAR_TO_INDEX]);
        return candidate.getAge() >= MIN_AGE_FOR_THE_CANDIDATE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearTo - yearFrom >= MIN_YEARS_OF_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

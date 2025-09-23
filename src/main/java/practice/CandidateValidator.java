package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_OF_YEAR_FROM = 0;
    private static final int INDEX_OF_YEAR_TO = 1;
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE_FOR_CANDIDATE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(periodInUkr[INDEX_OF_YEAR_FROM]);
        int yearTo = Integer.parseInt(periodInUkr[INDEX_OF_YEAR_TO]);
        return (candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && candidate.isAllowedToVote()
                && yearTo - yearFrom >= MIN_YEARS_OF_LIVING_IN_UKRAINE_FOR_CANDIDATE);
    }
}

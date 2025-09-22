package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int INDEX_OF_YEAR_FROM = 0;
    private final static int INDEX_OF_YEAR_TO = 1;
    private final static int MIN_AGE_FOR_CANDIDATE = 35;
    private final static String NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private final static int MIN_YEARS_OF_LIVING_IN_UKRAINE_FOR_CANDIDATE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(periodInUkr[INDEX_OF_YEAR_FROM]);
        int yearTo = Integer.parseInt(periodInUkr[INDEX_OF_YEAR_TO]);
        return (candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && candidate.isAllowedToVote()
                && yearTo - yearFrom >= MIN_YEARS_OF_LIVING_IN_UKRAINE_FOR_CANDIDATE );
    }
}

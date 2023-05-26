package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_LIVE_IN_UA = 10;
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        String nationality = candidate.getNationality();
        int liveInUa = liveInUkraine(candidate);
        return age >= MINIMUM_AGE && nationality.equals(NATIONALITY)
                && liveInUa >= MINIMUM_LIVE_IN_UA
                && candidate.isAllowedToVote();
    }

    private int liveInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        return Integer.parseInt(years[INDEX_TO_YEAR]) - Integer.parseInt(years[INDEX_FROM_YEAR]);
    }
}

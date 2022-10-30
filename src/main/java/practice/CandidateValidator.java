package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_FROM = 0;
    private static final int INDEX_TO = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(REGEX);
        int yearTo = Integer.parseInt(years[INDEX_TO]);
        int yearFrom = Integer.parseInt(years[INDEX_FROM]);

        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && yearTo - yearFrom >= MIN_PERIOD;
    }
}

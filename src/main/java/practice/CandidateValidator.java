package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;
    private static final String SPLITTERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        final String[] years = candidate.getPeriodsInUkr().split(SPLITTERATOR);
        final int periodInUkraine = Integer.parseInt(years[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(years[INDEX_OF_FIRST_YEAR]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

}

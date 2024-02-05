package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD = 10;
    private static final int ALLOWED_AGE = 35;
    private static final int INDEX_OF_START_YEAR = 0;
    private static final int INDEX_OF_END_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);

        int startYear = Integer.parseInt(periods[INDEX_OF_START_YEAR]);
        int endYear = Integer.parseInt(periods[INDEX_OF_END_YEAR]);
        int period = endYear - startYear;

        return candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= MIN_PERIOD;
    }
}

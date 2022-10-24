package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String RESULT_SPLIT = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final int TO_YEAR_INDEX = 1;
    private static final int FROM_YEAR_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD;
    }

    private int getPeriod(String period) {
        String[] years = period.split(RESULT_SPLIT);
        return Integer.parseInt(years[TO_YEAR_INDEX])
                - Integer.parseInt(years[FROM_YEAR_INDEX]);
    }
}

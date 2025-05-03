package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_YEARS_TO_LIVE = 10;
    private static final int MINIMAL_AGE = 35;
    private static final int END_PERIOD_INDEX = 1;
    private static final int START_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[END_PERIOD_INDEX])
                - Integer.parseInt(years[START_PERIOD_INDEX]);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period > MINIMAL_YEARS_TO_LIVE;
    }
}

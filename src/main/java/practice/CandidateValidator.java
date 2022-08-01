package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_TO_LIVE = 10;
    private static final int MIN_AGE = 35;
    private static final int END_OF_PERIOD = 1;
    private static final int START_OF_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[END_OF_PERIOD])
                - Integer.parseInt(years[START_OF_PERIOD]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && period > MIN_YEARS_TO_LIVE;
    }
}

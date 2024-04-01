package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS = 35;
    private static final int MIN_PERIOD = 10;

    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[END_YEAR_INDEX])
                - Integer.parseInt(years[START_YEAR_INDEX]);
        return candidate.getAge() >= MIN_YEARS
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_PERIOD
                && candidate.isAllowedToVote();
    }
}

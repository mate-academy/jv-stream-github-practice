package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(data[YEAR_TO_INDEX])
                - Integer.parseInt(data[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkr >= MIN_YEARS_TO_LIVE_IN_UKRAINE;
    }
}

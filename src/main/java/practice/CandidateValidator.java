package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR_POSITION = 0;
    private static final int LAST_YEAR_POSITION = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodResult = Integer.parseInt(period[LAST_YEAR_POSITION])
                - Integer.parseInt(period[FIRST_YEAR_POSITION]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodResult >= MIN_PERIOD;
    }
}

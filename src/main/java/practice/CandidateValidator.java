package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int LIVING_YEARS_FROM_INDEX = 0;
    private static final int LIVING_YEARS_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodResult = Integer.parseInt(period[LIVING_YEARS_TO_INDEX])
                - Integer.parseInt(period[LIVING_YEARS_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodResult >= MIN_PERIOD;
    }

}

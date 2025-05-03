package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && periodsInUkrBool(candidate);
    }

    private boolean periodsInUkrBool(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(DASH);
        int yearsInUkr = Integer.parseInt(split[TO_YEAR_INDEX])
                        - Integer.parseInt(split[FROM_YEAR_INDEX]);
        return yearsInUkr >= PERIOD_IN_UKRAINE;
    }
}

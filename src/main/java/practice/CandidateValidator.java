package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_PRESIDENCY_AGE = 35;
    static final int MIN_RESIDENCY_TERM = 10;
    static final String PRESIDENCY_NATIONALITY = "Ukrainian";
    static final int FROM_PERIOD_INDEX = 0;
    static final int TO_PERIOD_INDEX = 1;
    static final String PERIODS_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsSplit = candidate.getPeriodsInUkr().split(PERIODS_REGEX);

        return candidate.getAge() >= MIN_PRESIDENCY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(PRESIDENCY_NATIONALITY)
                && Integer.parseInt(periodsSplit[TO_PERIOD_INDEX])
                - Integer.parseInt(periodsSplit[FROM_PERIOD_INDEX])
                >= MIN_RESIDENCY_TERM;
    }
    //write your code here
}

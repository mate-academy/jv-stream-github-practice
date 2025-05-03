package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        int period = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && period > MIN_PERIOD;
    }
    //write your code here
}

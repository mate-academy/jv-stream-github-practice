package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate s) {
        return s.isAllowedToVote() && s.getAge() >= MIN_AGE
                && s.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(s.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(s.getPeriodsInUkr().split("-")[0])) >= MIN_PERIOD;
    }
}

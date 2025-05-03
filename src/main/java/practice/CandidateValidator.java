package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int PRESIDENT_MIN_AGE = 35;
    public static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= PRESIDENT_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(
                        candidate.getPeriodsInUkr().indexOf('-') + 1))
                        - Integer.parseInt(candidate.getPeriodsInUkr().substring(
                                0, candidate.getPeriodsInUkr().indexOf('-')))
                        >= MIN_PERIOD_IN_UKRAINE);
    }
}

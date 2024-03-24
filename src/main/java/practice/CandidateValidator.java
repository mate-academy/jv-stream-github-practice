package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 10;
    private static final int PERIOD = 10;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX1 = 4;
    private static final int BEGIN_INDEX2 = 5;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(BEGIN_INDEX2))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(BEGIN_INDEX, END_INDEX1)) >= PERIOD;
    }
}

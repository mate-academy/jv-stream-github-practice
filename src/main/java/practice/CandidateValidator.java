package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR = 0;
    private static final int SECOND_YEAR = 1;
    private static final int AGE = 35;
    private static final int PERIOD_LIFE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split("-");
        int yearsLife = Integer.parseInt(periodString[SECOND_YEAR])
                - Integer.parseInt(periodString[FIRST_YEAR]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsLife >= PERIOD_LIFE
                && candidate.getAge() >= AGE;
    }
}

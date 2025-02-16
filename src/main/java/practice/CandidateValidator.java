package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR_IN_UKR = 10;
    private static final int YEAR_LENGTH = 4;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");

        if (periodsInUkr[0].length() != YEAR_LENGTH
                && periodsInUkr[1].length() != YEAR_LENGTH) {
            throw new RuntimeException("Field periodsInUkr isn't correct");
        }

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periodsInUkr[1])
                - Integer.parseInt(periodsInUkr[0]) > MIN_YEAR_IN_UKR);
    }
}

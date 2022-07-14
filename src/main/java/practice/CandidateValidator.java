package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_OF_LIFE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getYearsOfLifeInUkr(candidate) >= YEARS_OF_LIFE_IN_UKR;
    }

    private static int getYearsOfLifeInUkr(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}

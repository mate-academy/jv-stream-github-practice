package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEAR_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && Integer.parseInt(periodsInUkr[1])
                - Integer.parseInt(periodsInUkr[0]) >= YEAR_IN_COUNTRY;
    }
}

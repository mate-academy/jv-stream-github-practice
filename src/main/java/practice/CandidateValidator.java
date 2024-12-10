package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_LIVED_IN_UKRAINE = 10;
    private static final int MINIMUM_AGE = 35;

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= YEAR_LIVED_IN_UKRAINE;
    }
}

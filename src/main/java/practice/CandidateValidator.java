package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int PERIOD_OF_LIFE_IN_UKRAINE = 10;
    private static final int AGE_FROM = 35;

    @Override
    public boolean test(Candidate candidate) {
        int one = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int two = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        return two - one >= PERIOD_OF_LIFE_IN_UKRAINE
                && candidate.getAge() >= AGE_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR);
    }
}

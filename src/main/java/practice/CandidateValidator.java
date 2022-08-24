package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_AMOUNT_YEAR_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split("-");
        int[] periodNumber = {Integer.parseInt(periodString[0]), Integer.parseInt(periodString[1])};
        int period = periodNumber[1] - periodNumber[0];
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_AMOUNT_YEAR_IN_UKRAINE;
    }

}

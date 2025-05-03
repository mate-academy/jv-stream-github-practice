package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String PROPER_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_FIELD = "-";
    private static final int PROPER_AGE = 35;
    private static final int PROPER_PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getNationality().equals(PROPER_NATIONALITY)
                && candidate.getAge() >= PROPER_AGE
                && (Integer.parseInt(candidate.getPeriodsInUkr().split(SEPARATOR_FIELD)[1])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR_FIELD)[0])) >= PROPER_PERIODS_IN_UKR) {
            return true;
        }
        return false;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int START_OF_STAY_INDEX = 0;
    private static final int END_OF_STAY_INDEX = 1;
    private Candidate candidate;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getPeriodsInUkr() == null) {
            return false;
        }
        String[] periodResidenceInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periodResidenceInUkraine[END_OF_STAY_INDEX])
                - Integer.parseInt(periodResidenceInUkraine[START_OF_STAY_INDEX])) >= 10;
    }

}

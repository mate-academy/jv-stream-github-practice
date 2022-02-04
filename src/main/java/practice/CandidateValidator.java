package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_TIME_IN_UKRAINE = 10;
    @Override
    public boolean test(Candidate candidate) {
        int toInUkraineYear = Integer.parseInt(candidate
                        .getPeriodsInUkr()
                        .substring(candidate.getPeriodsInUkr().indexOf('-') + 1));
        int fromInUkraineYear = Integer.parseInt(candidate
                        .getPeriodsInUkr()
                        .substring(0, candidate.getPeriodsInUkr().indexOf('-')));
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality() != null
                && candidate.getNationality().equals("Ukrainian")
                && toInUkraineYear - fromInUkraineYear >= MIN_TIME_IN_UKRAINE;
    }
}

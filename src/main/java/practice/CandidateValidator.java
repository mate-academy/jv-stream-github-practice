package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MAX_AGE = 35;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int MAX_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= MAX_AGE
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[SECOND_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_INDEX]))
                >= MAX_YEARS;
    }
}

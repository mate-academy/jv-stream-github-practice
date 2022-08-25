package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedYears = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(splitedYears[TO_YEAR_INDEX])
                - Integer.parseInt(splitedYears[FROM_YEAR_INDEX])) >= 10;
    }
}

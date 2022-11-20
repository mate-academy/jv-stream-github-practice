package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = Integer.parseInt(data[SECOND_INDEX])
                - Integer.parseInt(data[FIRST_INDEX]);
        return candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && periodsInUkr >= 10;
    }
}

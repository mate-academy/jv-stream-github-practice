package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int minYearIn = 10;
    private final int minYearOld = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(period[0].trim());
        int to = Integer.parseInt(period[1].trim());
        boolean validPeriod = to - from >= minYearIn;

        return candidate.getAge() >= minYearOld
                && validPeriod
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian");
    }
}

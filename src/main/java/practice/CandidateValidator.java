package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_YEAR = 2002;
    private static final int FINISH_YEAR = 2015;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int first = Integer.valueOf(split[0]);
        int second = Integer.valueOf(split[1]);
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && second - first >= 10
                && (first >= START_YEAR || second <= FINISH_YEAR)) {
            return true;
        }
        return false;
    }
}

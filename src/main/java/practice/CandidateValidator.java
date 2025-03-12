package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35 || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split("-");
        if (period.length != 2) {
            return false;
        }
        int start = Integer.parseInt(period[0]);
        int end = Integer.parseInt(period[1]);
        if ((end - start) < 10) {
            return false;
        }
        return true;
    }
}

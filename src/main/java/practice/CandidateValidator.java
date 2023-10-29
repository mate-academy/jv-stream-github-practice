package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        if ((endYear - startYear) < 10) {
            return false;
        }
        return true;
    }

}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }

        String periodInUkr = candidate.getPeriodsInUkr();
        String[] periods = periodInUkr.split("-");
        int start = Integer.parseInt(periods[1]);
        int end = Integer.parseInt(periods[0]);

        if ((start - end) < 10) {
            return false;
        }

        return true;
    }
}

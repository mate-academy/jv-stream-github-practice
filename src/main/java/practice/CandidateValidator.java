package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");

        try {
            int period = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

            if (period < 10) {
                return false;
            }
        }catch (NumberFormatException e) {
            throw new RuntimeException("Can't parseInt not number",e);
        }

        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return true;
    }

}

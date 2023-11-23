package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getPeriodsInUkr() != null) {
            String[] periods = candidate.getPeriodsInUkr().split("-");
            if (periods.length == 2) {
                int startYear = Integer.parseInt(periods[0]);
                int endYear = Integer.parseInt(periods[1]);
                return endYear - startYear >= 10;
            }
        }
        return false;
    }
}

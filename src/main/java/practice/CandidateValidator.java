package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35 || !candidate.isAllowedToVote()
                || !"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split("-");
        if (periods.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(periods[0].trim());
            int endYear = Integer.parseInt(periods[1].trim());
            return (endYear - startYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

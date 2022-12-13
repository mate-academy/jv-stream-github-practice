package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        Integer yearsTo = Integer.parseInt(years[1]);
        Integer yearsFrom = Integer.parseInt(years[0]);
        if (candidate.isAllowedToVote() == true
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && (yearsTo - yearsFrom) >= 10) {
            return true;
        }
        return false;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(yearsInUkr[0]);
        int endYear = Integer.parseInt(yearsInUkr[1]);

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (endYear - startYear) >= 10;
    }
}

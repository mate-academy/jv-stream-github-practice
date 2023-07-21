package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] fromYearToYearInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Integer.parseInt(fromYearToYearInUkr[1])
                    - Integer.parseInt(fromYearToYearInUkr[0]) >= 10;
    }
}

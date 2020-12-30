package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                    .substring(candidate.getPeriodsInUkr().indexOf("-") + 1))
                    - Integer.parseInt(candidate.getPeriodsInUkr()
                    .substring(0, candidate.getPeriodsInUkr().indexOf("-"))) > 10);
    }
}

package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(candidate.getPeriodsInUkr().indexOf("-") + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, candidate.getPeriodsInUkr().indexOf("-")))
                >= 10;
    }

}

package practice;

import model.Candidate;

import java.util.List;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35 &&
                candidate.getNationality().equals("Ukrainian") &&
                candidate.isAllowedToVote() &&
                Integer.parseInt(candidatePeriodsInUkr[1]) - Integer.parseInt(candidatePeriodsInUkr[0]) >=10;
    }
}

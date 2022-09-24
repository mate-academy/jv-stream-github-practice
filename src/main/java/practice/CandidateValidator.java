package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {


    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian") &&
                (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]) -
                        Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) > 10) &&
                candidate.isAllowedToVote());
    }
}


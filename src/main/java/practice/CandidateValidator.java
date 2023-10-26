package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split("-");
        int ageFrom = Integer.parseInt(ages[0]);
        int ageTo = Integer.parseInt(ages[1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && ageTo - ageFrom >= 10;
    }
}

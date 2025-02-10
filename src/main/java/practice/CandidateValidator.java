package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()
                || !candidate.getNationality().equals("Ukrainian")
                || candidate.getAge() < 35) {
            return false;
        }
        String[] split = candidate.getPeriodsInUkr().split("-");
        if (split.length != 2) {
            throw new IllegalArgumentException("Invalid period format: " + candidate.getPeriodsInUkr());
        }

        int startYear = Integer.parseInt(split[0]);
        int endYear = Integer.parseInt(split[1]);
        return (endYear - startYear) >= 10;
    }
}

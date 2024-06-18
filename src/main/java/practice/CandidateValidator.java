package practice;

import java.util.Arrays;
import java.util.function.Predicate;

import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35 || !candidate.isAllowedToVote() || !candidate.getNationality().equals("Ukrainian")) {
            return false;
        }

        int yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(",")).map(period -> period.split("-")).mapToInt(p -> Integer.parseInt(p[1]) - Integer.parseInt(p[0])).sum();

        return yearsInUkraine >= 10;
    }
}

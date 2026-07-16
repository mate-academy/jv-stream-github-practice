package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        int livedYear = Integer.parseInt(year[1]) - Integer.parseInt(year[0]);

        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livedYear >= 10;
    }
}

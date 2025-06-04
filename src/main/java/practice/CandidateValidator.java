package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsOfLivingInUkraine = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(yearsOfLivingInUkraine[0].trim());
        int endYear = Integer.parseInt(yearsOfLivingInUkraine[1].trim());
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && endYear - startYear >= 10;
    }
}

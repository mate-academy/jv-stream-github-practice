package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_IN_UKRAINE_NEEDED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        Integer startYear = Integer.parseInt(split[0]);
        Integer endYear = Integer.parseInt(split[1]);

        return (candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && endYear - startYear >= YEARS_IN_UKRAINE_NEEDED);
    }
}

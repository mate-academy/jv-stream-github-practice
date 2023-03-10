package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_NECESSARY_IN_UKRAINE = 10;
    private static final int YEAR_NECESSARY = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= YEAR_NECESSARY
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isLivedTenYears(candidate);
    }

    private boolean isLivedTenYears(Candidate candidate) {
        int ageLived = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("2", 2)))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        return ageLived >= YEAR_NECESSARY_IN_UKRAINE;
    }
}

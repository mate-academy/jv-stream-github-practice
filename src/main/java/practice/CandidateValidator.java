package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int AGE_OF_CANDIDACY = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote() && candidate.getAge() >= AGE_OF_CANDIDACY
                && candidate.getNationality().equals(NATIONALITY)) {
            String[] livingYears = candidate.getPeriodsInUkr().split("-");
            int termOfLiving = Integer.parseInt(livingYears[1]) - Integer.parseInt(livingYears[0]);
            return termOfLiving > MINIMUM_YEARS_LIVING;
        }
        return false;
    }
}

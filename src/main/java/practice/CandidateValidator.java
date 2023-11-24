package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getPeriodsInUkr() != null) {
            String[] periods = candidate.getPeriodsInUkr().split("-");
            if (periods.length == 2) {
                int startYear = Integer.parseInt(periods[0]);
                int endYear = Integer.parseInt(periods[1]);
                return endYear - startYear >= MIN_YEARS_IN_UKRAINE;
            }
        }
        return false;
    }
}

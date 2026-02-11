package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && CANDIDATE_NATIONALITY.equals(candidate.getNationality())
                && hasRequiredYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasRequiredYearsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null) {
            return false;
        }
        String[] period = periodsInUkr.split("-");
        if (period.length != 2) {
            return false;
        }
        int from = Integer.parseInt(period[0].trim());
        int to = Integer.parseInt(period[1].trim());
        if (to < from) {
            return false;
        }
        return to - from >= YEARS_IN_UKRAINE;
    }
}

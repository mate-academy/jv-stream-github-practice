package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_MOVED_TO_UKR_IDX = 0;
    private static final int YEAR_MOVED_FROM_UKR_IDX = 1;
    private static final int MIN_AGE_TO_STAND_FOR_ELECTION = 35;
    private static final int MIN_YEARS_TO_SPEND_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_TO_STAND_FOR_ELECTION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isCandidateLivedInUkrForTenYears(candidate);
    }

    private boolean isCandidateLivedInUkrForTenYears(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int movedTo = Integer.parseInt(years[YEAR_MOVED_TO_UKR_IDX]);
        int movedFrom = Integer.parseInt(years[YEAR_MOVED_FROM_UKR_IDX]);
        return movedFrom - movedTo >= MIN_YEARS_TO_SPEND_IN_UKRAINE;
    }
}

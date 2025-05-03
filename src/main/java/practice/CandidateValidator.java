package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE_FOR_PRESIDENT = 35;
    private static final int INDEX_START_YEAR = 0;
    private static final int INDEX_FINISH_YEAR = 1;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge()
                >= VALID_AGE_FOR_PRESIDENT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriodsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriodsInUkr(String periodsInUkr) {
        String[] yearsInUkr = periodsInUkr.split("-");
        int periodInUkr = Integer.parseInt(yearsInUkr[INDEX_FINISH_YEAR])
                - Integer.parseInt(yearsInUkr[INDEX_START_YEAR]);
        return periodInUkr > MIN_PERIOD_IN_UKR;
    }
}

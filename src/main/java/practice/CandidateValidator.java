package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_THRESHOLD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isLivedInUkr10Yeas(candidate.getPeriodsInUkr());
    }

    private boolean isLivedInUkr10Yeas(String getPeriodInUkr) {
        String[] datesInUkr = getPeriodInUkr.split("-");
        return (Integer.valueOf(datesInUkr[1]) - Integer.valueOf(datesInUkr[0]))
                >= YEARS_IN_UKRAINE;
    }
}

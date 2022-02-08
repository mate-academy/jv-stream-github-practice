package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATE_SPLITTER = "-";
    private static final int DATE_FROM_POS = 0;
    private static final int DATE_TO_POS = 1;
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
  public boolean test(Candidate candidate) {
        String[] splittedPeriodInUkr = candidate.getPeriodsInUkr().split(DATE_SPLITTER);
        int dateFrom = Integer.parseInt(splittedPeriodInUkr[DATE_FROM_POS]);
        int dateTo = Integer.parseInt(splittedPeriodInUkr[DATE_TO_POS]);
        return candidate.getAge() >= MIN_ALLOWED_AGE
            && candidate.isAllowedToVote()
            && candidate.getNationality().equals(NATIONALITY_UKR)
            && (dateTo - dateFrom) >= MIN_PERIOD_IN_UKR;
    }
}

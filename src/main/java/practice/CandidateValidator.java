package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NECESSARY_AGE = 35;
    private static final String NECESSARY_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";
    private static final int FIRST_DATE_OF_PERIOD = 0;
    private static final int LAST_DATE_OF_PERIOD = 1;
    private static final int NECESSARY_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= NECESSARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NECESSARY_NATIONALITY)
                && isPeriodValid(candidate.getPeriodsInUkr());
    }

    private boolean isPeriodValid(String period) {
        String[] dates = period.split(SPLIT_SYMBOL);
        return Integer.parseInt(dates[LAST_DATE_OF_PERIOD]) - Integer
                .parseInt(dates[FIRST_DATE_OF_PERIOD]) >= NECESSARY_PERIOD;
    }
}

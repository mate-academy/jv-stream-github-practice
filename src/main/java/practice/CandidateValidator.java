package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AVAILABLE_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String REGEX_FOR_SPLIT = "-";
    private static final int FROM_PERIOD_IN_UKR_INDEX = 0;
    private static final int TO_PERIOD_IN_UKR_INDEX = 1;
    @Override
    public boolean test(Candidate candidate) {
        String[] fromToPeriodInUkr = candidate.getPeriodsInUkr().split(REGEX_FOR_SPLIT);
        int timeLiveInUkr =
                Integer.parseInt(fromToPeriodInUkr[TO_PERIOD_IN_UKR_INDEX]) - Integer.parseInt(fromToPeriodInUkr[FROM_PERIOD_IN_UKR_INDEX]);
        return candidate.getAge() >= AVAILABLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && timeLiveInUkr >= MIN_YEARS;
    }
}

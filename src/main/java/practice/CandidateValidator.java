package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int START_PERIOD = 0;
    private static final int FINISH_PERIOD = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_AMOUNT_OF_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkSufficientAmountOfYears(candidate);
    }

    private boolean checkSufficientAmountOfYears(Candidate candidate) {
        if (candidate.getPeriodsInUkr() != null || !candidate.getPeriodsInUkr().isEmpty()) {
            String[] yearsFromTo = candidate.getPeriodsInUkr().split(SEPARATOR);
            return (Integer.parseInt(yearsFromTo[FINISH_PERIOD])
                    - Integer.parseInt(yearsFromTo[START_PERIOD])) >= MIN_AMOUNT_OF_YEARS;
        }
        return false;
    }
}

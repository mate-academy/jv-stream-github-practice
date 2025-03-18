package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIOD_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);

        try {
            return !(candidate.getAge() < MIN_AGE)
                    && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                    && candidate.isAllowedToVote()
                    && periods.length == 2
                    && Integer.parseInt(periods[END_YEAR_INDEX])
                   - Integer.parseInt(periods[START_YEAR_INDEX]) >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

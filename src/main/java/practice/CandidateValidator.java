package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_YEAR_OF_PERIOD = 1900;
    public static final int MAX_YEAR_OF_PERIOD = Year.now().getValue();
    public static final int MIN_AGE_FOR_CANDIDATE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.getPeriodsInUkr().contains("-")) {
            throw new RuntimeException("Incorrect periods");
        }
        String periods = candidate.getPeriodsInUkr();
        final int firstYear = Integer.parseInt(periods.substring(0, periods.indexOf("-")));
        final int lastYear = Integer.parseInt(periods.substring(periods.indexOf("-") + 1));
        if (firstYear < MIN_YEAR_OF_PERIOD || lastYear > MAX_YEAR_OF_PERIOD
                || firstYear > lastYear) {
            throw new RuntimeException("Incorrect periods");
        }
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && lastYear - firstYear >= MIN_YEARS_IN_UKRAINE;
    }
}

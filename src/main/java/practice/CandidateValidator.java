package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int RESIDENCE_DURATION = 10;
    private static final String PERIOD_DELIMITATION = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split(PERIOD_DELIMITATION);
        int startYear;
        int endYear;
        try {
            startYear = Integer.parseInt(periodYears[START_YEAR_INDEX]);
            endYear = Integer.parseInt(periodYears[END_YEAR_INDEX]);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        if (periodYears.length != 2) {
            throw new RuntimeException("Invalid period in " + candidate.getPeriodsInUkr()
                    + " Only \"YYYY-YYYY\" format is accepted");
        }
        if (startYear > endYear) {
            throw new RuntimeException("The date data is invalid: first field has to be the"
                    + "start of residence and the second one of finishing it.");
        }
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodYears[1]) - Integer.parseInt(periodYears[0])
                >= RESIDENCE_DURATION;
    }
}

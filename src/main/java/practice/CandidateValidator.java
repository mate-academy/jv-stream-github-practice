package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null && candidate.getAge() >= MINIMAL_AGE
                       && candidate.isAllowedToVote()
                       && candidate.getNationality().equals(NATIONALITY)
                       && getPeriodOfTime(candidate.getPeriodsInUkr()) >= MINIMAL_PERIOD;
    }

    private int getPeriodOfTime(String timeString) {
        String[] stringYears = timeString.split("-");
        return Integer.parseInt(stringYears[1]) - Integer.parseInt(stringYears[0]);
    }
}

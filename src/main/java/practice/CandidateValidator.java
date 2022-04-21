package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MINIMAL_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MINIMAL_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null && candidate.getAge() >= MINIMAL_AGE
                       && candidate.isAllowedToVote()
                       && candidate.getNationality().equals(NATIONALITY)
                       && getTime(candidate.getPeriodsInUkr()) >= MINIMAL_PERIOD;
    }

    private int getTime(String timeStrings) {
        String[] stringYears = timeStrings.split("-");
        return Integer.parseInt(stringYears[1]) - Integer.parseInt(stringYears[0]);
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MINIMAL_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getAge() < MINIMAL_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        return getTime(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getTime(String timeStrings) {
        String[] stringYears = timeStrings.split("-");
        return Integer.parseInt(stringYears[1]) - Integer.parseInt(stringYears[0]);
    }
}

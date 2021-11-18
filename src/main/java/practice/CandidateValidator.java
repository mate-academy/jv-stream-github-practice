package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVING_IN_UKRAINE = 10;
    private static final int FIRST_DATE_INDEX = 0;
    private static final int LAST_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(period[FIRST_DATE_INDEX]);
        int toYear = Integer.parseInt(period[LAST_DATE_INDEX]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && toYear - fromYear >= LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

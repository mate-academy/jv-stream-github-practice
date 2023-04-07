package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final String REGEX = "-";
    private static final int POSITION_START_YEAR = 0;
    private static final int POSITION_LAST_YEAR = 1;

    private static boolean candidateYearsLiveInUkraine(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split(REGEX);
        int fromYear = Integer.parseInt(parts[POSITION_START_YEAR]);
        int toYear = Integer.parseInt(parts[POSITION_LAST_YEAR]);
        return (toYear - fromYear) >= MINIMUM_YEARS_IN_UKRAINE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidateYearsLiveInUkraine(candidate);
    }
}

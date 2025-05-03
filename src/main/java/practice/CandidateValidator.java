package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String ADMISSIBLE_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEAR_IN_UKRAINE = 10;
    private static final String DASH = "-";
    private static final int INDEX_START_OF_RESIDENCE = 0;
    private static final int INDEX_END_OF_RESIDENCE = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && ADMISSIBLE_NATIONALITY.equals(candidate.getNationality())
                && hasRequiredYearsInUkraine(candidate);
    }

    private boolean hasRequiredYearsInUkraine(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(DASH);
        int startOfResidence = Integer.parseInt(periodInUkraine[INDEX_START_OF_RESIDENCE]);
        int endOfStay = Integer.parseInt(periodInUkraine[INDEX_END_OF_RESIDENCE]);

        return MINIMUM_YEAR_IN_UKRAINE <= endOfStay - startOfResidence;
    }
}

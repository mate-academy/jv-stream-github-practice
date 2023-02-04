package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_IN_UKRAINE = 10;
    public static final String YEAR_SEPARATOR = "-";
    public static final int FIRST_YEAR_IN_UA_INDEX = 0;
    public static final int LAST_YEAR_IN_UA_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && livedForMinYears(candidate.getPeriodsInUkr());
    }

    private boolean livedForMinYears(String candidateYearsInUkraine) {
        String[] splitYears = candidateYearsInUkraine.split(YEAR_SEPARATOR);
        return MIN_YEARS_IN_UKRAINE <= Integer.parseInt(splitYears[LAST_YEAR_IN_UA_INDEX])
                - Integer.parseInt(splitYears[FIRST_YEAR_IN_UA_INDEX]);
    }
}

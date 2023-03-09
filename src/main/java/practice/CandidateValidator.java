package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String SEPARATOR = "-";
    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 1;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MINIMUM_PERIOD_OF_LIVING_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        int startLivingYear = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[FIRST_INDEX]);
        int endLivingYear = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[LAST_INDEX]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && endLivingYear - startLivingYear >= MINIMUM_PERIOD_OF_LIVING_IN_COUNTRY;
    }
}

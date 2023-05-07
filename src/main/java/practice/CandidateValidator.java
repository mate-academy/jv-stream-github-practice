package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CORRECT_AGE = 35;
    private static final int MIN_LIVING_AGE_IN_UKR = 10;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final String HYPHEN_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CORRECT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CORRECT_NATIONALITY)
                && isMoreThanTenYears(candidate.getPeriodsInUkr());
    }

    private boolean isMoreThanTenYears(String periods) {
        String[] periodsInUkr = periods.split(HYPHEN_SEPARATOR);
        int startYear = Integer.parseInt(periodsInUkr[START_INDEX]);
        int endYear = Integer.parseInt(periodsInUkr[END_INDEX]);
        return endYear - startYear >= MIN_LIVING_AGE_IN_UKR;
    }
}

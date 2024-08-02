package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        String[] periods = periodsInUkr.split(DASH);
        int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);
        return (endYear - startYear) >= REQUIRED_YEARS_IN_UKRAINE;
    }
}

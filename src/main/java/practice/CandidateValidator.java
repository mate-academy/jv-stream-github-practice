package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final int INDEX_START = 0;
    private static final int INDEX_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == "Ukrainian"
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[INDEX_START]);
        int endYear = Integer.parseInt(periods[INDEX_END]);
        return (endYear - startYear) >= REQUIRED_YEARS_IN_UKRAINE;
    }
}

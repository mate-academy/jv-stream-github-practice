package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int NUMBERS_OF_YEARS = 10;
    private static final int FIRST_YEAR_INDEX = 1;
    private static final int SECOND_YEAR_INDEX = 0;
    private static final int COUNT_OF_YEARS = 2;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(CORRECT_NATIONALITY)) {
            return false;
        }
        int[] years = new int[COUNT_OF_YEARS];
        String[] strings = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        years[SECOND_YEAR_INDEX] = Integer.parseInt(strings[SECOND_YEAR_INDEX]);
        years[FIRST_YEAR_INDEX] = Integer.parseInt(strings[FIRST_YEAR_INDEX]);
        if (years[FIRST_YEAR_INDEX] - years[SECOND_YEAR_INDEX] <= NUMBERS_OF_YEARS) {
            return false;
        }
        return true;
    }
}

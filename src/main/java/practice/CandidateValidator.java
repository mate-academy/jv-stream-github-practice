package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int NUMBERS_OF_YEARS = 10;

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
        int[] years = new int[2];
        String[] strings = candidate.getPeriodsInUkr().split("-");
        years[0] = Integer.parseInt(strings[0]);
        years[1] = Integer.parseInt(strings[1]);
        if (years[1] - years[0] <= NUMBERS_OF_YEARS) {
            return false;
        }
        return true;
    }
}

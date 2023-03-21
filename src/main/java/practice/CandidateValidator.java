package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_LIFE_IN_COUNTRY = 10;
    private static final String SPLIT_SYMBOL = "-";
    private static final int LAST_YEAR = 1;
    private static final int INITIAL_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (countYearsInCountry(candidate.getPeriodsInUkr()) < PERIOD_OF_LIFE_IN_COUNTRY) {
            return false;
        }
        return true;
    }

    private int countYearsInCountry(String text) {
        String[] temp = text.split(SPLIT_SYMBOL);
        int[] period = new int[2];
        for (int i = 0; i < temp.length; i++) {
            period[i] = Integer.parseInt(temp[i]);
        }
        return period[LAST_YEAR] - period[INITIAL_YEAR];
    }
}

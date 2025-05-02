package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String NUMBER_SEPARATOR = "-";
    private static final int AGE_TO_APPLY = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int YEAR_FROM_POS = 0;
    private static final int YEAR_TO_POS = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (candidate.getNationality() == null
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        return candidate.getAge() >= AGE_TO_APPLY
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int yearsInUkraine(String years) {
        String[] yearsInUkr = years.split(NUMBER_SEPARATOR);
        return Integer.parseInt(yearsInUkr[YEAR_TO_POS])
                - Integer.parseInt(yearsInUkr[YEAR_FROM_POS]);
    }
}

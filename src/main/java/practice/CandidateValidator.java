package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int INDEX_OF_YEAR_ENTERING_UKRAINE = 0;
    public static final int INDEX_OF_LAST_YEAR_STAYING_IN_UKRAINE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] inUkraineFromAndTill = candidate.getPeriodsInUkr().split("-");
        int inUkraineFrom = Integer.parseInt(inUkraineFromAndTill[INDEX_OF_YEAR_ENTERING_UKRAINE]);
        int inUkraineTill = Integer.parseInt(inUkraineFromAndTill[INDEX_OF_LAST_YEAR_STAYING_IN_UKRAINE]);
        int yearsInUkraine = inUkraineTill - inUkraineFrom;
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final int LIVED_IN_UKRAINE_FROM_INDEX = 1;
    private static final int LIVED_IN_UKRAINE_TO_INDEX = 0;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int MIN_ALLOWED_CANDIDATE_AGE = 35;
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && isEnoughYearsInUkraine(candidate);
    }

    private boolean isEnoughYearsInUkraine(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int yearsInUA = Integer.parseInt(yearsInUkraine[LIVED_IN_UKRAINE_FROM_INDEX])
                - Integer.parseInt(yearsInUkraine[LIVED_IN_UKRAINE_TO_INDEX]);
        return yearsInUA >= MIN_YEARS_IN_UKRAINE;
    }
}

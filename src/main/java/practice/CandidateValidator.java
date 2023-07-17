package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    public static final int VALID_YEARS_IN_UKRAINE = 10;
    public static final int TO_YEAR_INDEX = 1;
    public static final int FROM_YEAR_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals("Ukrainian")
                && hasLivedFor10Years(candidate);
    }

    private boolean hasLivedFor10Years(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[TO_YEAR_INDEX]) - Integer.parseInt(period[FROM_YEAR_INDEX])
                >= VALID_YEARS_IN_UKRAINE;
    }
}

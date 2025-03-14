package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;
    private static final boolean ALLOWED_TO_VOTE = true;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > MIN_AGE && candidate.isAllowedToVote() == ALLOWED_TO_VOTE && candidate.getNationality().equals(NATIONALITY) && hasLivedUkraineForRequiredYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedUkraineForRequiredYears(String period) {
        String[] str = period.split(",");

        try {
            return str.length == 2 && Integer.parseInt(str[1]) -
                    Integer.parseInt(str[0]) >= LIVE_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

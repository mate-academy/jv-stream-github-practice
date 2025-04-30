package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;

    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasLivedUkraineForRequiredYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedUkraineForRequiredYears(String period) {
        String[] str = period.split(SEPARATOR);

        if (str.length != 2) {
            return false;
        }

        try {
            int startOfYear = Integer.parseInt(str[0]);
            int endOfYear = Integer.parseInt(str[1]);
            return (endOfYear - startOfYear) >= LIVE_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

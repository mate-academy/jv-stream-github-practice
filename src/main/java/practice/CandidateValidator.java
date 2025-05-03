package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int YEAR_NECESSARY_IN_UKRAINE = 10;
    private static final int NECESSARY_AGE = 35;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= NECESSARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && isLivedTenYears(candidate);
    }

    private boolean isLivedTenYears(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split(REGEX);
        return (Integer.parseInt(year[1]) - Integer.parseInt(year[0])) >= YEAR_NECESSARY_IN_UKRAINE;
    }
}

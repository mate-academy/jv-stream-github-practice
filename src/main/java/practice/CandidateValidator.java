package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int VALID_YEAR_NUMBER = 10;
    private static final String SPLIT_SYMBOL = "-";

    private static boolean periodIsValid(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= VALID_YEAR_NUMBER;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && periodIsValid(candidate);
    }
}

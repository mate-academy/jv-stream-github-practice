package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_ALLOWED_AGE = 10;
    private static final int START_YEAR = 0;
    private static final String NATIONALITY = "Ukrainian";
    private static final int END_YEAR = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_CANDIDATE
                && NATIONALITY.equals(candidate.getNationality())
                && Integer.parseInt(periods[END_YEAR]) - Integer.parseInt(periods[START_YEAR])
                >= MIN_ALLOWED_AGE;
    }
}

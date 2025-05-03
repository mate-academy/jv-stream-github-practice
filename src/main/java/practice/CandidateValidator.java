package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String REGEX_FOR_SPLIT = "-";
    private static final int YEARS_THRESHOLD = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(REGEX_FOR_SPLIT);
        return candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && (Integer.parseInt(periodsInUkr[YEAR_TO])
                - Integer.parseInt(periodsInUkr[YEAR_FROM])) > YEARS_THRESHOLD;
    }
}

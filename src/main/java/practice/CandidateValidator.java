package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final String PATTERN = "-";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int SUITABLE_PERIOD = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] range = candidate.getPeriodsInUkr().split(PATTERN);
        int period = Integer.parseInt(range[SECOND_INDEX]) - Integer.parseInt(range[FIRST_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN) && period >= SUITABLE_PERIOD;
    }
}

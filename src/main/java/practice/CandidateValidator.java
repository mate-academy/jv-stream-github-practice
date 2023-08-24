package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int END_INDEX = 1;
    private static final int START_INDEX = 0;
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String LINE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(LINE_SEPARATOR);
        int period = Integer.parseInt(periods[END_INDEX]) - Integer.parseInt(periods[START_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && period > MIN_PERIOD;
    }
}

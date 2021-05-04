package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int VALID_AGE = 35;
    public static final String VALID_NATIONALITY = "Ukrainian";
    public static final int VALID_PERIOD = 10;
    public static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] stringPeriod = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int period = Integer.parseInt(stringPeriod[1]) - Integer.parseInt(stringPeriod[0]);
        return candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && period >= VALID_PERIOD
                && candidate.isAllowedToVote();
    }
}


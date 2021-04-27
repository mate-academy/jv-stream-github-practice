package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NEEDED_NATIONALITY = "Ukrainian";
    public static final String SPLITERATOR = "-";
    public static final int NEEDED_PERIOD = 10;
    public static final int NEEDED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] stringPeriod = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int periodInYears = Integer.parseInt(stringPeriod[1]) - Integer.parseInt(stringPeriod[0]);
        return candidate.getAge() >= NEEDED_AGE
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && periodInYears >= NEEDED_PERIOD
                && candidate.isAllowedToVote();
    }
}

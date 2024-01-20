package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String SPLITERATOR = "-";
    public static final int MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(SPLITERATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && (Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]) >= MIN_PERIOD);
    }
}

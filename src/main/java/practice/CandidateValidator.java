package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_TO = 1;
    private static final int INDEX_FROM = 0;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(period[INDEX_TO])
                - Integer.parseInt(period[INDEX_FROM]) > MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DELIMITER = "-";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split(DELIMITER);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(splitted[1]) - Integer.parseInt(splitted[0]))
                >= MIN_PERIODS_IN_UKRAINE && candidate.isAllowedToVote();
    }
}

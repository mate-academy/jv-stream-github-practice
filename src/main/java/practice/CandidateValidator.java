package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_THE_CANDIDATE = 35;
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(DELIMITER);
        int start = Integer.parseInt(period[0]);
        int end = Integer.parseInt(period[1]);
        return candidate.getAge() >= MIN_AGE_FOR_THE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && end - start >= MIN_YEARS_OF_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final String ACCEPTABLE_CITIZENSHIP = "Ukrainian";
    private static final String DATA_DELIMITER = "-";
    private static final int ACCEPTABLE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] citizenYears = candidate.getPeriodsInUkr().split(DATA_DELIMITER);
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.getNationality().equals(ACCEPTABLE_CITIZENSHIP)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(citizenYears[1])
                - Integer.parseInt(citizenYears[0])) >= ACCEPTABLE_PERIOD;
    }
}

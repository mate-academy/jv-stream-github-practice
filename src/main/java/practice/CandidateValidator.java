package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DELIMITER = "-";
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodsData = candidate.getPeriodsInUkr();
        int totalYears = Integer.parseInt(periodsData.substring(periodsData.indexOf(DELIMITER) + 1))
                - Integer.parseInt(periodsData.substring(0, periodsData.indexOf(DELIMITER)));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && totalYears >= 10;
    }
}

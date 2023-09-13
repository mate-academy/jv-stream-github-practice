package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int MIN_REQUIRED_UKR_PERIOD = 10;
    private static final String NATIONALITY_REQUIREMENTS = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        int startYear = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DELIMITER)[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DELIMITER)[END_YEAR_INDEX]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIREMENTS)
                && endYear - startYear >= MIN_REQUIRED_UKR_PERIOD;
    }
}

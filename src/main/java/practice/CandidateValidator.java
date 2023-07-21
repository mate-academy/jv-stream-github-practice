package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_LIVING_IN_UKR = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int YEAR_OF_LIVING_FROM = 0;
    private static final int YEAR_OF_LIVING_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(DATA_SEPARATOR);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && MIN_PERIOD_LIVING_IN_UKR
                    <= Integer.parseInt(periodsInUkraine[YEAR_OF_LIVING_TO])
                    - Integer.parseInt(periodsInUkraine[YEAR_OF_LIVING_FROM]);
    }
}

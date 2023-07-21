package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_INDEX_FROM = 0;
    private static final int PERIOD_INDEX_TO = 1;
    private static final int MIN_AGE = 35;
    private static final int LIVING_IN_UKR_REQUIREMENT = 10;
    private static final String SEPARATOR = "-";
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);

        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(UKRAINIAN)
                && Integer.parseInt(period[PERIOD_INDEX_TO])
                - Integer.parseInt(period[PERIOD_INDEX_FROM]) > LIVING_IN_UKR_REQUIREMENT
                && candidate.isAllowedToVote();
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int NEEDED_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_FINISH_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {

        String[] period = candidate.getPeriodsInUkr().split("-");
        Integer periodStar = Integer.parseInt(period[PERIOD_START_INDEX]);
        Integer periodFinish = Integer.parseInt(period[PERIOD_FINISH_INDEX]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && periodFinish - periodStar >= NEEDED_YEARS_IN_UKRAINE;
    }
}

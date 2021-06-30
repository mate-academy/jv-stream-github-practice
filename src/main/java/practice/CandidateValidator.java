package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int START_PERIOD_INDEX = 0;
    public static final int FINISH_PERIOD_INDEX = 1;
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && isPeriodAppropiate(candidate)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY);
    }

    private boolean isPeriodAppropiate(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int start = Integer.parseInt(period[START_PERIOD_INDEX]);
        int finish = Integer.parseInt(period[FINISH_PERIOD_INDEX]);
        return finish - start >= MIN_YEARS_PERIOD;
    }
}

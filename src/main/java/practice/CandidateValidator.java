package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_RUNNING = 35;
    private static final int MIN_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY_FOR_RUNNING = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraineArray = candidate.getPeriodsInUkr().split(SEPARATOR);
        int fromAge = Integer.parseInt(periodInUkraineArray[0]);
        int toAge = Integer.parseInt(periodInUkraineArray[1]);
        int periodLivingInUkraine = toAge - fromAge;
        return candidate.getAge() >= MIN_AGE_FOR_RUNNING
                && candidate.getNationality().equals(NATIONALITY_FOR_RUNNING)
                && candidate.isAllowedToVote()
                && periodLivingInUkraine >= MIN_PERIOD_LIVING_IN_UKRAINE;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int START_OF_PERIOD = 0;
    private static final int END_OF_PERIOD = 1;
    private static final String NATION = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String [] livingInUkrainePeriod = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startLivingInUkraine = Integer.parseInt(livingInUkrainePeriod[START_OF_PERIOD]);
        int endLivingInUkraine = Integer.parseInt(livingInUkrainePeriod[END_OF_PERIOD]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATION.equals(candidate.getNationality())
                && endLivingInUkraine - startLivingInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}

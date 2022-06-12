package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_FOR_RUNNING = 35;
    public static final int PERIOD_LIVING_IN_UKRAINE= 10;
    public static final  String NATIONALITY_FOR_RUNNING = "Ukrainian";
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= MIN_AGE_FOR_RUNNING
                && candidate.getNationality().equals(NATIONALITY_FOR_RUNNING)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4))) >= PERIOD_LIVING_IN_UKRAINE;
    }
}

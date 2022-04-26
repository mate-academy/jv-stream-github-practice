package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_REQUIRED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_RESIDENCY_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine(candidate)
                && candidate.isAllowedToVote();
    }

    private boolean periodInUkraine(Candidate candidate) {
        String periodSpentInUkraine = candidate.getPeriodsInUkr();
        String[] periodArray = periodSpentInUkraine.split("-");
        return Integer.parseInt(periodArray[1])
                - Integer.parseInt(periodArray[0]) >= MINIMAL_RESIDENCY_PERIOD;
    }
}

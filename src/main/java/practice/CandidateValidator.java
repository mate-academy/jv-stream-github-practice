package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String stayInUkraineFrom = candidate.getPeriodsInUkr().split("-")[0];
        String stayInUkraineTo = candidate.getPeriodsInUkr().split("-")[1];
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(stayInUkraineTo)
                - Integer.parseInt(stayInUkraineFrom)) >= MINIMAL_YEARS_IN_UKRAINE;
    }
}

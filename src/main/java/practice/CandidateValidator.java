package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(splitted[PERIOD_TO_INDEX])
                - Integer.parseInt(splitted[PERIOD_FROM_INDEX]) >= REUIRED_MIN_PERIOD_IN_COUNTRY);
    }
}

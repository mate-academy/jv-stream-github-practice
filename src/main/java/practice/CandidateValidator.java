package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
            && candidate.isAllowedToVote()
            && candidate.getNationality().equals(REQUIRED_NATIONALITY)
            && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) >= MIN_PERIOD;
    }
}

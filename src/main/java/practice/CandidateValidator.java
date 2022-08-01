package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_AGE = 35;
    public static final int MIN_LIVING_PERIOND = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && (Integer.parseInt(period[1])
                - Integer.parseInt(period[0]) >= MIN_LIVING_PERIOND);
    }
}


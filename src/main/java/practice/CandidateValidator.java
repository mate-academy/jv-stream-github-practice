package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE_CANDIDATE = 35;
    private static final int MIN_AGE_LIVED = 10;

    private static final String CORRECT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {

        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");

        int livedDuration = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);

        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(CORRECT_NATIONALITY)
                && candidate.isAllowedToVote()
                && livedDuration >= MIN_AGE_LIVED;
    }
}

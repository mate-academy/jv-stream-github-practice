package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String requiredNationality = "Ukrainian";
    private static final int requiredPeriodsInUkr = 10;
    private static final int MIN_AGE_REQUIRED = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(requiredNationality)
                && candidate.getAge() >= MIN_AGE_REQUIRED
                && candidate.isAllowedToVote()
                && chkPeriodsInUkraine(candidate);
    }

    private static boolean chkPeriodsInUkraine(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-", 2);
        return (Integer.valueOf(period[1]) - Integer.valueOf(period[0])) >= requiredPeriodsInUkr;

    }
}

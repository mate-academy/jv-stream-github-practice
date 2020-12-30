package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final int DURATION_LIVE = 10;
    private static final String NATIONAL_COUNTRY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsFromTill = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.parseInt(yearsFromTill[1])
                - Integer.parseInt(yearsFromTill[0]);

        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL_COUNTRY)
                && period >= DURATION_LIVE;
    }
}

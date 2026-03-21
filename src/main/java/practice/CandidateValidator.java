package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIMIMUM_AGE_TO_BE_PRESIDENT = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIMIMUM_AGE_TO_BE_PRESIDENT) {
            return false;
        }
        if (!NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split("-");
        String sinceWhen = period[0];
        String till = period[1];
        return (Integer.parseInt(till) - Integer.parseInt(sinceWhen) >= MINIMUM_PERIOD_IN_UKRAINE);
    }
}


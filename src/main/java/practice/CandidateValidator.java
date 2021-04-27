package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int LAST_YEAR = 1;
    private static final int FIRST_YEAR = 0;
    private static final int ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("[^\\d]");
        boolean isLivedInUkraine = (Integer.parseInt(period[LAST_YEAR])
                - Integer.parseInt(period[FIRST_YEAR])) > ALLOWED_PERIOD;
        return candidate.getAge() >= ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN) && isLivedInUkraine;
    }
}

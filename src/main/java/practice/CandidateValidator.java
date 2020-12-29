package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int ALLOWED_AGE = 35;
    public static final String UKRAINIAN = "Ukrainian";
    public static final int LAST_YEAR = 1;
    public static final int FIRST_YEAR = 0;
    public static final int ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("[^\\d]");
        boolean isLivedInUkraine = (Integer.parseInt(period[LAST_YEAR])
                - Integer.parseInt(period[FIRST_YEAR])) > ALLOWED_PERIOD;
        return candidate.getAge() >= ALLOWED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN) && isLivedInUkraine;
    }
}

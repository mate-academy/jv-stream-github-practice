package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN = 35;
    private static final int LIVE_HERE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= OLDER_THAN
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(periods[1]) - Integer.parseInt(periods[0])) >= LIVE_HERE;
    }
}

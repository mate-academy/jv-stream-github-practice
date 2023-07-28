package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MIN_CANDIDATE_YEAR = 35;
    private static int MIN_PERIOD = 10;
    private static int FROM_YEAR = 0;
    private static int TO_YEAR = 1;
    private static String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periodsInUkr[TO_YEAR])
                - Integer.parseInt(periodsInUkr[FROM_YEAR]);
        return candidate.getAge() >= MIN_CANDIDATE_YEAR
               && candidate.getNationality().equals(NATIONALITY)
               && candidate.isAllowedToVote()
               && period >= MIN_PERIOD;
    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int FROM = 1;
    private static final int TO = 0;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()) {
            String[] periodsInUkr = candidate.getPeriodsInUkr()
                    .split("-");
            return (Integer.parseInt(periodsInUkr[FROM]) - Integer.parseInt(periodsInUkr[TO])) > 10;
        }
        return false;
    }
}

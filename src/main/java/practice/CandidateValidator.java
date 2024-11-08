package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_AGE = 35;
    static final int MIN_YEAR_IN_UKRAINE = 10;
    static final String NATIONALITY_NEEDED = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr()
                .split("-");
        int yearsInUkraine = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_NEEDED)
                && yearsInUkraine >= MIN_YEAR_IN_UKRAINE;
    }
}

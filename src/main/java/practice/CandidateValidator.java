package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONAL = "Ukrainian";
    private static final String SEPARATE = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsFromTill = candidate.getPeriodsInUkr().split(SEPARATE);
        int period = Integer.parseInt(yearsFromTill[1])
                - Integer.parseInt(yearsFromTill[0]);

        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && period >= 10;
    }
}

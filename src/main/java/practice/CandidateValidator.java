package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String RIGHT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && RIGHT_NATIONALITY.equals(candidate.getNationality())
                && getPeriod(candidate) >= 10;
    }

    private int getPeriod(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
    }
}

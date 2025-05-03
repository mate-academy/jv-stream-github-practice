package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TEN_YEAR = 10;
    private static final String UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR)
                && Integer.parseInt(split[1]) - Integer.parseInt(split[0]) >= TEN_YEAR) {
            return true;
        }
        return false;
    }
}

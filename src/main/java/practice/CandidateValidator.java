package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int validAge = 35;
    private final int validPeriod = 10;
    private String nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(nationality)
                && candidate.isAllowedToVote()
                && candidate.getAge() == validAge
                && getYearsInUkr(candidate) >= validPeriod;
    }

    private int getYearsInUkr(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodString[1]) - Integer.parseInt(periodString[0]);
    }
}

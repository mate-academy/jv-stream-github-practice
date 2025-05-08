package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int age = 35;
    private String nationality = "Ukrainian";
    private int periodsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= age)
                && (candidate.getNationality().equals(nationality))
                && getPeriodInUkr(candidate.getPeriodsInUkr());
    }

    private boolean getPeriodInUkr(String period) {
        String[] dates = period.split("-");
        int fromYear = 0;
        int toYear = 0;
        try {
            fromYear = Integer.parseInt(dates[0]);
            toYear = Integer.parseInt(dates[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return (toYear - fromYear + 1) >= periodsInUkr;
    }
}

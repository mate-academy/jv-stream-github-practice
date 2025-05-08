package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int age = 35;
    private String nationality = "Ukrainian";
    private int periodsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] dates = period.split("-");
        int periodInt = Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]);
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= age)
                && (candidate.getNationality().equals(nationality))
                && (periodInt >= periodsInUkr);
    }
}

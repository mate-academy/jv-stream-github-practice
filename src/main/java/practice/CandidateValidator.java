package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return endYear - startYear;
    }
}

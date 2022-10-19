package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriodInUkraine(String period) {
        String[] years = period.split("-");
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return yearsInUkraine >= 10;
    }
}

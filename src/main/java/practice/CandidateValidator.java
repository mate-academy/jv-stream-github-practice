package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 &&
                candidate.isAllowedToVote() &&
                "Ukrainian".equals(candidate.getNationality()) &&
                calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }
    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear;
    }
}

package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        return getPeriodInUkraineInt(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getPeriodInUkraineInt(String period) {
        if (period != null && !period.isEmpty()) {
            String[] years = period.split("-");
            return years.length > 1
                    ? Integer.parseInt(years[1]) - Integer.parseInt(years[0])
                    : Integer.parseInt(years[0]);
        }
        return 0;
    }
    //write your code here
}

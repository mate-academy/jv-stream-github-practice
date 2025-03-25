package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && hasTenYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasTenYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(years[0].trim());
            int endYear = Integer.parseInt(years[1].trim());
            return (endYear - startYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

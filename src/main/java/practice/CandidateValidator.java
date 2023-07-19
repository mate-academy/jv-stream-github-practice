package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_TO_RUN_FOR_PRESIDENT = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equalsIgnoreCase("Ukrainian")
                && candidate.getAge() >= MIN_YEAR_TO_RUN_FOR_PRESIDENT
                && calculateYearsInUkraine(candidate) > 10
                && candidate.isAllowedToVote();
    }

    private int calculateYearsInUkraine(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear;
    }
}

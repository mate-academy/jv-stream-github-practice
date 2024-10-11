package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int ENOUGH_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isAgeValid(candidate)
                && isNationalityValid(candidate)
                && isAllowedToVote(candidate)
                && isEnoughYearsInUkraine(candidate);
    }

    private boolean isAgeValid(Candidate candidate) {
        return candidate.getAge() >= 35;
    }

    private boolean isAllowedToVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    private boolean isNationalityValid(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian");
    }

    private boolean isEnoughYearsInUkraine(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split(SEPARATOR);
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        int yearsInUkraine = endYear - startYear;
        return yearsInUkraine >= ENOUGH_YEARS;
    }
}

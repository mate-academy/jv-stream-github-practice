package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isAgeValid = candidate.getAge() >= MIN_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isNationalityValid = REQUIRED_NATIONALITY.equals(candidate.getNationality());
        boolean isPeriodValid = Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .anyMatch(period -> {
                    String[] years = period.split("-");
                    if (years.length == 2) {
                        int startYear = Integer.parseInt(years[0]);
                        int endYear = Integer.parseInt(years[1]);
                        return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
                    }
                    return false;
                });
        return isAgeValid && isAllowedToVote && isNationalityValid && isPeriodValid;
    }
}

package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        boolean isAgeValid = candidate.getAge() >= 35;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isNationalityValid = "Ukrainian".equals(candidate.getNationality());
        boolean isPeriodValid = Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .anyMatch(period -> {
                    String[] years = period.split("-");
                    if (years.length == 2) {
                        int startYear = Integer.parseInt(years[0]);
                        int endYear = Integer.parseInt(years[1]);
                        return (endYear - startYear) >= 10;
                    }
                    return false;
                });
        return isAgeValid && isAllowedToVote && isNationalityValid && isPeriodValid;
    }
}

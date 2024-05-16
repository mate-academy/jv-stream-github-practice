package practice;

import model.Candidate;
import model.Person;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate {
    //write your code here
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVED_TEN_YEARS = 10;

    @Override
    public boolean test(Object o) {
        Candidate candidate = (Candidate) o;
        boolean isHeHaveEnoughYears = candidate.getAge() > MINIMAL_AGE;
        boolean isHeHaveCorrectNationality = candidate.getNationality()
                .equals(NATIONALITY);

        int from = 0;
        int to = 1;
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int livedInCountry = Integer.parseInt(splitPeriods[1]) -
                Integer.parseInt(splitPeriods[0]);
        boolean isHeLivedInCountryEnough = livedInCountry > LIVED_TEN_YEARS;

        return isHeHaveEnoughYears && isHeHaveCorrectNationality && isHeLivedInCountryEnough;
    }
}

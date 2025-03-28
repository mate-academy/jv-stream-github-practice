package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        int minAge = 35;
        String nationality = "Ukrainian";

        return candidate.getAge() >= minAge
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        try {
            String[] years = periodsInUkr.split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            int minimumYearsInCountry = 10;

            return (endYear - startYear) >= minimumYearsInCountry;
        } catch (Exception e) {
            return false;
        }
    }
}

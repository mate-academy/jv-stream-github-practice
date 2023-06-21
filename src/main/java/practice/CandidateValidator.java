package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_RESIDENCY_YEARS = 10;

    public boolean test(Candidate candidate) {
        // Check if the candidate is at least 35 years old
        boolean isAtLeast35YearsOld = candidate.getAge() >= MINIMUM_AGE;
        // Check if the candidate is allowed to vote
        boolean isAllowedToVote = candidate.isAllowedToVote();
        // Check if the candidate has Ukrainian nationality
        boolean hasUkrainianNationality = NATIONALITY.equalsIgnoreCase(candidate.getNationality());

        // Get the candidate's period of residence in Ukraine
        String periodsInUkr = candidate.getPeriodsInUkr();
        if (isAtLeast35YearsOld
                && isAllowedToVote
                && hasUkrainianNationality
                && periodsInUkr != null
                && !periodsInUkr.isEmpty()) {
            // Split the period into start and end years
            String[] years = periodsInUkr.split("-");
            if (years.length == 2) {
                // Convert the start year to an integer
                int startYear = Integer.parseInt(years[0]);
                // Convert the end year to an integer
                int endYear = Integer.parseInt(years[1]);
                // Calculate the number of residency years
                int residencyYears = endYear - startYear;
                // Return true if the candidate meets all the eligibility criteria
                return residencyYears >= MINIMUM_RESIDENCY_YEARS;
            }
        }
        return false; // Return false if any of the conditions is not met
    }
}



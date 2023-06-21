package practice;

import java.time.LocalDate;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_RESIDENCY_YEARS = 10;

    public boolean test(Candidate candidate) {
        LocalDate now = LocalDate.now();
        int candidateAge = candidate.getAge();
        boolean isAtLeast35YearsOld = candidateAge >= MINIMUM_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean hasUkrainianNationality = NATIONALITY.equalsIgnoreCase(candidate.getNationality());

        if (!isAtLeast35YearsOld || !isAllowedToVote || !hasUkrainianNationality) {
            return false;
        }

        String periodsInUkr = candidate.getPeriodsInUkr();
        if (periodsInUkr != null && !periodsInUkr.isEmpty()) {
            String[] years = periodsInUkr.split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                int residencyYears = now.getYear() - startYear + 1;

                return residencyYears >= MINIMUM_RESIDENCY_YEARS || now.getYear() <= endYear;
            }
        }
        return false;
    }
}

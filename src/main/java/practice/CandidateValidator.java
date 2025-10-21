package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidat) {
        if (candidat == null) {
            return false;
        }
        if (!candidat.isAllowedToVote()) {
            return false;
        }
        if (!REQUIRED_NATIONALITY.equals(candidat.getNationality())) {
            return false;
        }

        boolean isValid = candidat.getAge() >= MIN_AGE
                && candidat.isAllowedToVote()
                && candidat.getNationality().equals(REQUIRED_NATIONALITY);
        if (!isValid) {
            return false;
        }
        String[] years = candidat.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            int yearsInUkraine = endYear - startYear;
            return yearsInUkraine >= REQUIRED_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}

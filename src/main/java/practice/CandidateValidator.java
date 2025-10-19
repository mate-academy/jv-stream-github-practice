package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public boolean test(Candidate candidat) {
        if (candidat == null) {
            return false;
        }
        boolean isValid = candidat.getAge() >= 35
                && candidat.isAllowedToVote()
                && candidat.getNationality().equals("Ukrainian");
        if (!isValid) {
            return false;
        }
        String[] years = candidat.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        int yearsInUkraine = endYear - startYear;

        return yearsInUkraine >= 10;

    }
}

package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int maxAge = 35;
    private static final String nationality = "Ukrainian";
    private static final int periodOfResidenceInUkraine = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < maxAge || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(nationality)) {
            return false;
        }
        String periodsInUkr = candidate.getPeriodsInUkr();
        if (periodsInUkr != null) {
            String[] years = periodsInUkr.split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                int yearsInUkraine = endYear - startYear;
                return yearsInUkraine >= periodOfResidenceInUkraine;
            }
        }
        return true;
    }
}

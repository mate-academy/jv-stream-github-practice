package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getNationality() == null
                || candidate.getPeriodsInUkr() == null || candidate.getPeriodsInUkr().isEmpty()) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }

        int startYear;
        int endYear;
        try {
            startYear = Integer.parseInt(years[0]);
            endYear = Integer.parseInt(years[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        int yearsInUkraine = endYear - startYear;

        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && yearsInUkraine >= 10;
    }
}

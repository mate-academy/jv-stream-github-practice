package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && candidate.getPeriodsInUkr() != null
                && candidate.getPeriodsInUkr().matches("\\d{4}-\\d{4}")
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length == 2) {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return endYear - startYear;
        }
        return 0;
    }
}

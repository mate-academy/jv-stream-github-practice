package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private String nationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && nationality.equals(candidate.getNationality())
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        if (periodsInUkr == null) {
            return false;
        }

        int allYearsInUkr = 0;
        String [] allPeriods = periodsInUkr.split(",");
        for (String period : allPeriods) {
            String[] years = period.split("-");
            int from = Integer.parseInt(years[0]);
            int to = Integer.parseInt(years[1]);
            allYearsInUkr += to - from;
        }

        return allYearsInUkr >= 10;
    }

}

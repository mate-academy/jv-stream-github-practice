package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculatePeriodsInUkr(candidate) >= 10;
    }

    private int calculatePeriodsInUkr(Candidate candidate) {
        String periods = candidate.getPeriodsInUkr();
        String[] years = periods.split("-");
        if (years.length == 2) {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return endYear - startYear + 1;
        }
        return 0;
    }
}

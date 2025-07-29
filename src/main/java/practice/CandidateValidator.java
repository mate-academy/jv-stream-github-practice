package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");

        if (years.length != 2) {
            return false;
        }
        try {
            int fromYear = Integer.parseInt(years[0]);
            int toYear = Integer.parseInt(years[1]);
            return (toYear - fromYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

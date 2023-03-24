package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private boolean checkPeriodInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);

        return endYear - startYear >= 10;
    }

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && checkPeriodInUkraine(candidate)) {
            return true;
        }
        return false;
    }
}

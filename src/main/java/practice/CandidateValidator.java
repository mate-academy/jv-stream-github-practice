package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        int yearsLived = endYear - startYear;
        return candidate.isAllowedToVote() && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && yearsLived >= 10;
    }
}

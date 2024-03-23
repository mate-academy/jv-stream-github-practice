package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calculateYearsInUkraine(String periodsInUkr) {
        // Предполагается, что periodsInUkr имеет формат "XXXX-YYYY"
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear + 1;
    }
}

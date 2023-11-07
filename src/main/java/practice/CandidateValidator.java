package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static boolean isUkrainianResidentFor10Years(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }

        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);

        return endYear - startYear >= 10;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isUkrainianResidentFor10Years(candidate.getPeriodsInUkr());
    }
}

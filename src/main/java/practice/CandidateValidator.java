package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int min_leaving_years = 10;
    private static final int min_Age = 35;
    private static final String nationality = "Ukrainian";

    private static boolean validateYears(String years) {
        if (years == null) {
            throw new RuntimeException("Years of leaving is missing");
        }
        String[] year = years.split("-");
        return (Integer.parseInt(year[1]) - Integer.parseInt(year[0])) >= min_leaving_years;
    }

    @Override
    public boolean test(Candidate candidate) {
        return validateYears(candidate.getPeriodsInUkr())
                && candidate.getAge() >= min_Age
                && candidate.getNationality().equals(nationality)
                && candidate.isAllowedToVote();
    }
}

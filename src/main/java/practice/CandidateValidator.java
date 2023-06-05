package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String name = candidate.getName();
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        String periodsInUkr = candidate.getPeriodsInUkr();

        return age >= 35 && allowedToVote
                && nationality.equals("Ukrainian")
                && hasLivedInUkraineFor10Years(periodsInUkr)
                && candidate.getName().equals(name);
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        int totalYearsInUkraine = 0;

        String[] years = periodsInUkr.split("-");
        if (years.length > 1) {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);

            Year startDate = Year.of(startYear);
            Year endDate = Year.of(endYear);

            totalYearsInUkraine = endDate.compareTo(startDate);
        }

        return totalYearsInUkraine >= 10;
    }
}

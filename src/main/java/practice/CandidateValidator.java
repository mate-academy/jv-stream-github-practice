package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        System.out.println("Checking candidate: " + candidate.getName());
        System.out.println("Age: " + candidate.getAge()
                + ", Allowed to Vote: " + candidate.isAllowedToVote()
                + ", Nationality: " + candidate.getNationality()
                + ", Periods in Ukraine: " + candidate.getPeriodsInUkr());

        if (candidate.getAge() < 35 || !candidate.isAllowedToVote()
                || !"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().trim().split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);

            System.out.println("Start Year: " + startYear + ", End Year: " + endYear);

            return endYear - startYear >= 10;
        } catch (NumberFormatException e) {
            System.out.println("Invalid period format for candidate " + candidate.getName());
            return false;
        }
    }
}

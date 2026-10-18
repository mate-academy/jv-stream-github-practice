package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35; // Мінімальний вік кандидата
    private static final int MIN_YEARS_IN_UKRAINE = 10; // Мінімальний термін проживання в Україні

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && checkYearsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean checkYearsInUkr(String periods) {
        // "2002-2015" -> 2015 - 2002 = 13 >= 10
        String[] years = periods.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
    }
}

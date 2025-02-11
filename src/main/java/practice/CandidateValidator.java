package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-"; // Delimiter for the periodsInUkr string
    private static final int START_YEAR_INDEX = 0; // Index for the start year in the periods array
    private static final int END_YEAR_INDEX = 1; // Index for the end year in the periods array

    @Override
    public boolean test(Candidate candidate) {
        // Check if the candidate meets the age requirement
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        // Check if the candidate is allowed to vote
        if (!candidate.isAllowedToVote()) {
            return false;
        }

        // Check if the candidate has the correct nationality
        if (!NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        // Check if the candidate has lived in Ukraine for at least 10 years
        String[] periods = candidate.getPeriodsInUkr().split(DELIMITER);
        if (periods.length < 2) {
            return false; // Invalid period format
        }

        // Parse the start and end years
        int startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(periods[END_YEAR_INDEX]);

        // Calculate the number of years lived in Ukraine
        int yearsInUkraine = endYear - startYear;

        return yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}

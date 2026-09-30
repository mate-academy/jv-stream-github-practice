package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] years = period.split(DASH_SEPARATOR);
        int start = Integer.parseInt(years[START_YEAR_INDEX]);
        int end = Integer.parseInt(years[END_YEAR_INDEX]);
        int yearsInUkr = end - start;

        return candidate.getAge() >= MIN_AGE // Виправлено: >= замість >
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}

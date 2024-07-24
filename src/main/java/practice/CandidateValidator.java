package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String SPLITTER = "-";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    public static final Predicate<Candidate> isAtLeast35YearsOld = c -> c.getAge() >= MIN_AGE;

    public static final Predicate<Candidate> isAllowedToVote = Candidate::isAllowedToVote;

    public static final Predicate<Candidate> isUkrainian = c -> c.getNationality()
                                                                 .equals(REQUIRED_NATIONALITY);

    public static final Predicate<Candidate> hasLivedInUkraineFor10Years = c ->
            countYears(c.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;

    public static final Predicate<Candidate> isValidCandidate = isAtLeast35YearsOld
                                                                .and(isAllowedToVote)
                                                                .and(isUkrainian)
                                                                .and(hasLivedInUkraineFor10Years);

    private static int countYears(String yearRange) {
        String[] parts = yearRange.split(SPLITTER);
        int startYear = Integer.parseInt(parts[FIRST_INDEX]);
        int endYear = Integer.parseInt(parts[SECOND_INDEX]);
        return endYear - startYear;
    }

    @Override
    public boolean test(Candidate candidate) {
        return isValidCandidate.test(candidate);
    }
}

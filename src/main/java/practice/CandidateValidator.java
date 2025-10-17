package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int MIN_YEAR_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate != null && candidate.getNationality() != null) {
            return (candidate.getAge() >= MIN_PRESIDENT_AGE)
                    && (candidate.isAllowedToVote())
                    && (Objects.equals(candidate
                                        .getNationality()
                                        .trim(), NATIONALITY))
                    && (getYearsInUkraine(candidate
                                        .getPeriodsInUkr()) >= MIN_YEAR_IN_UKRAINE);
        }
        return false;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return 0;
        }

        String[] periods = periodsInUkr.split("-");
        if (periods.length != 2) {
            return 0;
        }

        try {
            int startYear = Integer.parseInt(periods[0].trim());
            int endYear = Integer.parseInt(periods[1].trim());
            return endYear >= startYear ? endYear - startYear : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

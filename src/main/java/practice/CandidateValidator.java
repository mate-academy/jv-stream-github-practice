package practice;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<String> {
    private static final int MINIMUM_NUMBER_YEARS = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        return (Integer.parseInt(years[END_YEAR])
                - Integer.parseInt(years[START_YEAR])) >= MINIMUM_NUMBER_YEARS;
    }
}


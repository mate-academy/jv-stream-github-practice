package practice;

import java.util.function.Predicate;

import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isValid = candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasLivedUkraineForRequiredYears(candidate.getPeriodsInUkr());

        System.out.println("Candidate: " + candidate.getName() +
                " | Age: " + candidate.getAge() +
                " | Allowed to vote: " + candidate.isAllowedToVote() +
                " | Nationality: " + candidate.getNationality() +
                " | Lived in Ukraine: " + candidate.getPeriodsInUkr() +
                " | isValid: " + isValid);

        return isValid;
    }

    private boolean hasLivedUkraineForRequiredYears(String period) {
        String[] str = period.split("-");

        if (str.length != 2) {
            return false;
        }

        try {
            int startOfYear = Integer.parseInt(str[0].trim());
            int endOfYear = Integer.parseInt(str[1].trim());
            return (endOfYear - startOfYear) >= LIVE_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

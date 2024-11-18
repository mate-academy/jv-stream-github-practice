package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static Predicate<Candidate> isEligibleForPresident() {
        return candidate -> {
            boolean isOldEnough = candidate.getAge() >= 35;
            boolean canVote = candidate.isAllowedToVote();
            boolean isUkrainian = "Ukrainian".equalsIgnoreCase(candidate.getNationality());
            boolean spentEnoughTimeInUkraine =
                    calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= 10;

            /*
            Testy debugujące błąd dodania Kandydata

            System.out.println("----------");
            System.out.println(candidate.getName());
            System.out.println("Wiek kandydata " + candidate.getAge());
            System.out.println("isOldEnough " + isOldEnough);
            System.out.println("canVote " + canVote);
            System.out.println("isUkrainian " + isUkrainian);
            System.out.println("spentEnoughTimeInUkraine " + spentEnoughTimeInUkraine);
            System.out.println("----------");
             */

            return isOldEnough && canVote && isUkrainian && spentEnoughTimeInUkraine;
        };
    }

    private static int calculateYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);

        return endYear - startYear + 1;
    }

    @Override
    public boolean test(Candidate candidate) {
        return isEligibleForPresident().test(candidate);
    }

    @Override
    public Predicate<Candidate> and(Predicate<? super Candidate> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Candidate> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Candidate> or(Predicate<? super Candidate> other) {
        return Predicate.super.or(other);
    }
}

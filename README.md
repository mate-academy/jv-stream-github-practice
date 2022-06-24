# Stream practice

1.  Given list of strings where each element contains 1+ numbers:
    input = {"5,30,100", "0, 22, 7", ...}
    return min integer value. One more thing - we're interested in even numbers.
    If there is no needed data throw RuntimeException with message "Can't get min value from list: method_input_list".
    
2.  Given a List of Integer numbers,
    subtract 1 from each element on an odd position (having the odd index).
    Then return the average of all odd numbers or throw NoSuchElementException.

3.  Given a List of `People` instances (having `name`, `age` and `sex` fields),
    for example, `Arrays.asList( new People(«Victor», 16, Sex.MAN), new People(«Helen», 42, Sex.WOMEN))`,
    select from the List only men whose age is from `fromAge` to `toAge` inclusively.
    Example: select men who can be recruited to army (from 18 to 27 years old inclusively).
    
4.  Given a List of `People` instances (having `name`, `age` and `sex` fields),
    for example, `Arrays.asList( new People(«Victor», 16, Sex.MAN), new People(«Helen», 42, Sex.WOMEN))`,
    select from the List only people whose age is from `fromAge` and to `maleToAge` (for men)
    or to `femaleToAge` (for women) inclusively.
    Example: select people of working age
    (from 18 y.o. and to 60 y.o. for men and to 55 y.o. for women inclusively).

5.  Given a List of `People` instances (having `name`, `age`, `sex` and `List<Cat> cats` fields,
    and each `Cat` having a `name` and `age`),
    return the names of all cats whose owners are women from `femaleAge` years old inclusively.

6.  Your help with a election is needed. Given list of candidates, where each element has Candidate.class type.
    Check which candidates are eligible to apply for president position and return their names sorted alphabetically.
    The requirements are: person should be at least 35 years old, should be allowed to vote, have nationality - 'Ukrainian'
    and live in Ukraine for 10 years. For the last requirement use field periodsInUkr, which has following view:
    "2002-2015" For now we don't care if that was last 10 or not. We want to reuse our validation in future, so
    let's write our own impl of Predicate<Candidate> in CandidateValidator.

[Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/java-eight-part-two/stream-api)

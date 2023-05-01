## Common mistakes (jv-stream-github-practice)

#### Try to use a minimum amount of stream operations 
 * If you have a long boolean expression you may create your own implementation of Predicate and use it in your filter.
 * Where possible try to use single map operation instead of sequence of them. 
 * If you need to throw exception when no result found after stream execution sometimes `get()/getAsDouble()` may help, try to google what does it do.

#### Use Stream API to solve all tasks. Don't use loops.
#### Remember about the difference between bitwise and boolean operators.
#### Pay attention to what is a better way to compare Enum values: equals() vs == ?
[Hint](https://stackoverflow.com/a/1750453)
#### Call each new method from a new line in the stream. It will look better. For example:
```
List<String> data = new ArrayList();
data.stream()
        .distinct()
        .filter(x-> x.length()<5)
        .map(Integer::valueOf)
        .collect(Collectors.toList());
```
#### Use constants 
Magic numbers and strings decrease code readability, let's avoid it and use constants in 
class CandidateValidator

#### Use validator properly
If you need to pass your custom `Predicate` implementation into filter there are two optimal solutions  
``` 
Predicate<Candidate> customPredicate = new CustomPredicate<>();
Collection.stream()
    .filter(predicate)
    ...
```  
Or:  
``` 
Collection.stream()
        .filter(new CustomPredicate());
        ...
```

#### In method `findMinEvenNumber()` exception message should look like this:
```
"Can't get min value from list: " + numbers
```

## Basic knowledge (term based)
### Term
#### Simple
##### variable
chars start with [A-Z_] and consist with [A-Za-z0-9_]
```prolog
?- var(_asd). 
true.
?- var(ada)
false.
```
##### constant
###### atom
- chars start with [a-z] and consist with [A-Za-z0-9_]
```prolog
?- atom(a123).
true.
```

- chars enclosed in ''
```prolog
?- atom('asdfasd').
true.
```

- special characters:
, and
. or
:- imply
! cut

###### number
- type: integer, float 
- operator: +, -, *, /, **, 
- built-in func: 

random, between, succ, abs, max, min, mod

round, ceiling, truncate

#### Complex
consistant with simple term --> fact, predicate
##### style: functor(Arguments)
functor come from 1st atom ([A-Za-z0-9_] start with [a-z]

arguments come from all types of terms pred(pred1(pred2(pred3())))

##### arity: number of arguments
side note: /2 means two arguments.
X is min(1, 2)/2, X is abs(1)/1

### Fact: predicate / relation without variable

### Rule: 
#### innerquery (logical combination) 
```prolog
mother(X, Y):-
    parent(X, Y),
    female(X).

father(X, Y):-
    parent(X, Y),
    male(X).

sister(X, Y):-
    parent(Z, X),
    parent(Z, Y),
    female(X),
    X \== Y.

brother(X, Y):-
    parent(Z, X),
    parent(Z, Y), 
    male(X),
    X \== Y.

aunt(X, Y):-
    sister(X, P),
    parent(P, Y).

uncle(X, Y):-
   brother(X, P),
   parent(P, Y).
```

#### recursion

### Query: 


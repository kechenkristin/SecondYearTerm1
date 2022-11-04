## Basic knowledge (term based)
### Term
1. Simple
- variable
chars start with [A-Z_] and consist with [A-Za-z0-9_]
```prolog
?- var(_asd). 
true.
?- var(ada)
false.
```
- constant
	- atom
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

	- number
		- type: integer, float 
		- operator: +, -, *, /, **, 
		- built-in func: random, between, succ, abs, max, min, mod, round, ceiling, truncate

2. Complex
consistant with simple term --> fact, predicate
- style: functor(Arguments)
functor come from 1st atom ([A-Za-z0-9_] start with [a-z]

arguments come from all types of terms pred(pred1(pred2(pred3())))

- arity: number of arguments
side note: /2 means two arguments.
X is min(1, 2)/2, X is abs(1)/1

### Fact: predicate / relation without variable
```prolog
parent(tina, william)
male(steve)
```

### Rule: 
1. innerquery (logical combination) 
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

grandparent(X, Y):-
    parent(X, PY),
    parent(PY, Y).

```

2. recursion(call itself)
- basic case / backtrack case / stop option
- recursive part
```prolog
ancestor(X, Y):-
    parent(X, Y).

ancestor(X, Y):-
    parent(X, Z),
    ancestor(Z, Y).

descendant(X, Y):-
    parent(Y, X).

descendant(X, Y):-
    parent(Y, Z),
    descendant(Z, X).
```

### Query: (database / knowledge base)
1. unification rule (if binary terms are unified "="
#### simple term
- for constant and variable, if them are identical
```prolog
?- a = a
true.
?- a = b
false.
```
- for variable
	- if only one of them is variable: variable can be substituted by constant
	```
	X = 1.	
	X = 'ABZ'.
	```
	- if both of them are variables: variables can be substituted by another
	```
	X = Y, Y = 2.
	```

#### complex term(predicate)
- same functor + same arity
- inner unification reference simple term
```prolog
?- like(govern, apple) = like(X, Y).
X = govern,
Y = apple.

?- like(govern, apple) = like(X, X).
false

?- like(govern, apple) = like(apple).
false.

?- like(govern, apple) = hate(X, Y).
false.
```
3. operator compare: =, is, =:=
- = 	compare items of both sides
- is 	compare left side and arithmetic result of right 
- =:= 	compare arithmetic result of both sides

4. search strategy: DFS
- dfs + backtrack
- ! cut -> inhibite backtrack

5. examples
```prolog
% recursion
% factorial: 0! = 1, 1!= 1,..., 5!=120
% basic case
factorial(0, 1):-!.
factorial(Num, Fact):-
    Num_next is Num - 1,
    factorial(Num_next, Fact_next),
    Fact is Num * Fact_next.
```

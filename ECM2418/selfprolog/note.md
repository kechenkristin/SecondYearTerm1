## Basic knowledge (term based)
### Term
1. Simple
- variable
chars start with [A-Z_] and consist with [A-Za-z0-9_]
> ?- var(_asd). 

> true.

> ?- var(ada)

> false.
- constant
- atom
- chars start with [a-z] and consist with [A-Za-z0-9_]
> ?- atom(a123).

> true.

- chars enclosed in ' '
> ?- atom('asdfasd').

> true.

- special characters:
	- , and
	- . or
	- :- imply
	- ! cut

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
> ?- a = a

> true.

> ?- a = b

> false.
- for variable
	- if only one of them is variable: variable can be substituted by constant
							X = 1.	
							X = 'ABZ'.
	- if both of them are variables: variables can be substituted by another
							X = Y, Y = 2.

#### complex term(predicate)
- same functor + same arity
- inner unification reference simple term

> ?- like(govern, apple) = like(X, Y).

> X = govern,

> Y = apple.

> ?- like(govern, apple) = like(X, X).

> false

> ?- like(govern, apple) = like(apple).

> false.

> ?- like(govern, apple) = hate(X, Y).

> false.

3. operator compare: =, is, =:=
- = 	compare items of both sides

> ?- Y = 4 + 3.

> Y = 4 + 3.

> ?- X + 3 = 4 + Y.

> ?- X + john = mary + Y.

> X = mary.

> Y = john.

- is 	compare left side and arithmetic result of right 

> ?- Y is 4 + 3.

> Y = 7.

- =:= 	compare arithmetic result of both sides

> ?- 5 + 7 =:= 3 * 4.

> true

- ==  : x==y is true only if x and y are identical(same structure, corresponding components identical)

> ?- X = 1 + 1, X == 1 + 1.

> X = 1 + 1.

> ?- X = 1 + 1, X == 2.

> false.

> ?- X is 1 + 1, X == 1 + 1.

> false.

> ?- X is 1 + 1, X == 2.

> X = 2.

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

```prolog
% power: 2^0 = 1, 2^1 = 2, ..., 
% X ^ Y = Result
% power(_, 0, 1).
power(_, 0, 1) :- !.
power(X, Y, Result) :-
	Y_next is Y - 1,
	power(X, Y_next, Result_next),
	Result is Result_next * X.
```

```prolog
% 1, 1, 2, 3, 5, 8, 13, ...
% fib(index, fib_value)
fib(1, 1) : -!.
fib(2, 1) : -!.
fib(Index, Value) :-
	Index_1 is Index - 1,
	Index_2 is Index - 2,
	fib(Index_1, Value1),
	fib(Index_2, Value2),
	Value is Value1 + Value2.
```

### Data Structure
#### List
1. [H | T] or .(H, T)

2. Creat
- copy
```prolog
% List Copy
copy([H | T], [H | T]).
```
- duplicate
```prolog
% List Duplicate
duplicate_twice([], []).
duplicate_twice([H | T1], [H, H | T2]) :-
	duplicate_twice(T1, T2).
```

3. Read - filter
```prolog
% List Traverse
visit([]).
visit([H | T]) :-
	format('Current Visit is : ~w ~n', [H]),
	visit(T).

visit([]).
visit([H | T]) :-
	% filter
	0 is mod(H, 2),
	% map
	X is H ** 2,
	format('Result is: ~w ~n', [X]),
	visit(T).
```
4. Update - filter
```prolog
update([], []).
update([H1 | T1], [H2 | T2]) :-
	1 is mod(H1, 2),
	H2 = 'a',
	update(T1, T2).

update([H1 | T1], [H2 | T2]) :-
	0 is mod(H1, 2),
	H2 = 'b',
	update(T1, T2).
```

```prolog
% Update
% update Index item of list to be the modified
update([H | T], Index, Update, _) :-
	length([H | T], Length),
	Length < Index,
	!, fail.
update([_ | T], 0, Update, [Update | T]) :- !.
update([H | T1], Index, Update, [H | T2]) :-
	Index_next is Index - 1,
	update(T1, Index_next, Update,T2).
```

5. Delete
```prolog
% Delete
delete(X, Index, _) :-
	length(X, Length),
	Length < Index,
	!, fail.
delete([_ | T], 0, T) :- !.
delete([H | T1], Index, [H | T2]) :-
	Index_next is Index - 1,
	delete(T1, Index_next, T2).
```

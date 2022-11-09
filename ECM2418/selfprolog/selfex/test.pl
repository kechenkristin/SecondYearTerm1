% example1 eating
is_digesting(X,Y)  :-  just_ate(X,Y).
is_digesting(X,Y)  :-
	just_ate(X,Z),
	is_digesting(Z,Y).

% example2 descent
just_ate(mosquito,blood(john)).
just_ate(frog,mosquito).
just_ate(stork,frog).

descend1(X,Y)  :-  child(X,Y).
descend1(X,Y)  :-  
	child(X,Z),
	descend1(Z,Y).


child(anne,bridget).
child(bridget,caroline).
child(caroline,donna).
child(donna,emily).

% example3 Successor
numeral(0).
numeral(succ(X)) :- numeral(X).

% example4 addition
add(0, Y, Y).
add(succ(X), Y, succ(Z)) :-
	add(X, Y, Z).



grid(L1,[H2|T2],L3) :-
	append(L1,[H2],NewL1),
	append(NewL1,T2,L3).

takeout(X,[X|R],R).
takeout(X,[F |R],[F|S]) :- takeout(X,R,S).

perm([X|Y],Z) :- perm(Y,W), takeout(X,Z,W).
perm([],[]).

test(X,Y,Z) :-
	((third_quadrant(Z);
		forth_quadrant(Z)),
		((first_quadrant(X), second_quadrant(Y));
		(first_quadrant(Y), second_quadrant(X))));
((second_quadrant(Z);
		forth_quadrant(Z)),
		((first_quadrant(X), third_quadrant(Y));
		(first_quadrant(Y), third_quadrant(X)))).


first_quadrant(X) :- between(1,1,X).
second_quadrant(X) :- between(2,2,X).
third_quadrant(X) :- between(3,3,X).
forth_quadrant(X) :- between(4,4,X).

first(NQ,N) :-
	NQ = 1,
	between(0,90,N).
second(NQ,N) :-
	NQ = 2,
	between(91,180,N).
third(NQ,N) :-
	NQ = 3,
	between(181,270,N).
forth(NQ,N) :-
	NQ = 4,
	between(271,359,N).

qtn(XQ,X) :-
	first(XQ,X);
	second(XQ,X);
	third(XQ,X);
	forth(XQ,X).

quadrant_to_num(XQ,YQ,ZQ,X,Y,Z) :-
	qtn(XQ,X),
	qtn(YQ,Y),
	qtn(ZQ,Z).


possible(X,Y,Z) :-
	permutation([1,2,3,4],[XQ,YQ,ZQ,_]),
	quadrant_to_num(XQ,YQ,ZQ,X,Y,Z).

pp(X,Y,Z) :-
	between(0,359,X),
	between(0,359,Y),
	between(0,359,Z),
	X =\= Y,
	X =\= Z,
	Y =\= Z.

ppq(XQ,YQ,ZQ) :-
	(XQ is 1,
	YQ is 2,
	ZQ is 3);
	(XQ is 1,
	YQ is 2,
	ZQ is 4);
	(XQ is 1,
	YQ is 3,
	ZQ is 4);
	(XQ is 2,
	YQ is 3,
	ZQ is 4).

combination(0, _, []) :-
    !.
combination(N, L, [V|R]) :-
    N > 0,
    NN is N - 1,
    unknown(V, L, Rem),
    combination(NN, Rem, R).

unknown(X,[X|L],L).
unknown(X,[_|L],R) :-
    unknown(X,L,R).

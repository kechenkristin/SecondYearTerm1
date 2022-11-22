last([X],X).
last([_|T],R) :- last(T,R).

/*
stars_acc(0,A,A) :- !.
stars_acc(OldNum,[42|AccR],R) :-
	NewNum is OldNum - 1,
	stars_acc(NewNum,AccR,R).

stars(X,R) :- stars_acc(X,[],R).
*/
stars(0,[]).
stars(N,[42|W]) :-
	N1 is N - 1,
	stars(N1,W).

blat([],[]).
blat([E],[E]).
blat([E,F],[E,F]).
blat([H1|T1],[H1|T2]) :-
	length(T1,N),
	N1 is N -1,
	stars(N1,U),
	last(T1,V),
	append(U,[V],T2).

censor(V,W) :-
	name(V,A),
	blat(A,B),
	name(W,B).

censorall([],[]) :- !.
censorall([H1|T1],[H2|T2]) :-
	censor(H1,H2),
	censorall(T1,T2).

rude(damn).
rude(blast).

censorsome([H1|T1],[H2|T2]) :-
	rude(H1),
	censor(H1,H2),
	censorall(T1,T2).

censorsome([H1|T1],[H1|T2]) :-
	not(rude(H1)),
	censorall(T1,T2).

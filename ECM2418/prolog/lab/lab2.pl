lenAcc([],A,A).

lenAcc([_|T],OldAcc,Result) :-
	NewAcc is OldAcc + 1,
	lenAcc(T,NewAcc,Result).

lengthlist(List,Result) :- lenAcc(List,0,Result).

takelist(_,[],[]).
takelist(0,_,[]).
takelist(X,[H1|T1],[H1|T2]) :-
	NewX is X -1,
	takelist(NewX,T1,T2).

droplist(_,[],[]).
droplist(0,L,L).

droplist(X,[_|T1],L2) :-
	NewX is X - 1,
	droplist(NewX,T1,L2).

splitlist(0,List,[],List).
splitlist(_,[],[],[]).
splitlist(X,L1,L2,L3) :- 
	takelist(X,L1,L2),
	droplist(X,L1,L3).
	

squares([],[]).
squares([H1|T1],[H2|T2]) :- H2 is H1 * H1, squares(T1,T2).


evens([],[]).
evens([H1|T1],[H1|T2]) :-
	0 is H1 mod 2,
	evens(T1,T2).
evens([H1|T1],T2) :-
	1 is H1 mod 2,
	evens(T1,T2).


triangles(0,[]).
triangles(X,[H|T]) :-
	H is X * (X+1) / 2,
	NewX is X - 1,
	triangles(NewX,T).

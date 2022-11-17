/*Begin Question 3.1*/
match([H|_],0,H) :- !.
match([_|T],N,H) :-
	N1 is N-1,
	match(T,N1,H).

accindices([],_,Acc,Acc).
accindices([H1|T1],L2,OldAcc,Result) :-
	match(L2,H1,H3),
	accindices(T1,L2,[H3|OldAcc],Result).

% reverse a list accumulator
accRev([H|T],A,R) :- 
	accRev(T,[H|A],R).
	accRev([],A,A).

% wrapper for accRev
rev(L,R) :- accRev(L,[],R).

indices(IS,XS,ES) :- 
	accindices(IS,XS,[],RS), 
	rev(RS,ES).
/*End Question 3.1*/


/*Begin Question 3.2*/
takeout(X,[X|R],R).
takeout(X,[F|R],[F|S]) :- takeout(X,R,S).

perm([],[]).
perm([X|Y],Z) :- perm(Y,W), takeout(X,Z,W).

possible(GRID) :- perm([1,2,3,4,5,6,7,8,9],GRID).
/*End Question 3.2*/

 /*Begin Question 3.3*/
% accumulator sum of element in a list
accsum([],A,A).
accsum([H|T],AccOld,Sum) :-
	AccNew is AccOld + H,
	accsum(T,AccNew,Sum).

% wrapper
sum_list(L,S) :- accsum(L,0,S).

acceptable(T0,T1,T2,T3,US,U,VS,V,WS,W,GRID) :-
	indices([0,1,3,4],GRID,T0ES),
	sum_list(T0ES,T0),
	indices([1,2,4,5],GRID,T1ES),
	sum_list(T1ES,T1),
	indices([3,4,6,7],GRID,T2ES),
	sum_list(T2ES,T2),
	indices([4,5,7,8],GRID,T3ES),
	sum_list(T3ES,T3),
	indices(US,GRID,USES),
	sum_list(USES,U),
	indices(VS,GRID,VSES),
	sum_list(VSES,V),
	indices(WS,GRID,WSES),
	sum_list(WSES,W).


suko(T0,T1,T2,T3,US,U,VS,V,WS,W,GRID) :-
	possible(GRID),
	acceptable(T0,T1,T2,T3,US,U,VS,V,WS,W,GRID).
/*End Question 3.3*/

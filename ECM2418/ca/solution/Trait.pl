prime(2).
prime(3).
prime(N) :-
	integer(N),
	N > 3,
	N mod 2 =\= 0,
	not(has_factor(N,3)).

has_factor(N,F) :- N mod F =:= 0.
has_factor(N,F) :-
	F * F < N,
	NewF is F + 2,
	has_factor(N,NewF).

possible(X,Y,Z) :-
	between(0,359,X),
	between(0,359,Y),
	between(0,359,Z).


num_list_acc(0,A,A) :- !.
num_list_acc(X,OldAcc,L) :-
	XLast is X mod 10,
	append(OldAcc,[XLast],NewAcc),
	XRemain is X // 10,
	num_list_acc(XRemain,NewAcc,L).

num_list(X,L) :- num_list_acc(X,[],L).

three_num_list(X,Y,Z,LR) :-
	num_list(X,L1),
	num_list(Y,L2),
	num_list(Z,L3),
	append(L1,L2,LT),
	append(LT,L3,LR).

three_num_list_sort(X,Y,Z,LRS) :- 
	three_num_list(X,Y,Z,LR),
	sort(LR,LRS).

same_list([],[]).
same_list([H1|T1],[H2|T2]) :-
	H1 = H2,
	same_list(T1,T2).

acceptable(X,Y,Z) :-
	not(prime(X)),
	not(prime(Y)),
	not(prime(Z)),
	three_num_list_sort(X,Y,Z,L),
	same_list(L,[1,2,3,4,5,6,7,8,9]).

trait(X,Y,Z) :-
	possible(X,Y,Z),
	acceptable(X,Y,Z).

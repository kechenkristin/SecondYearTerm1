/*Begin Question 4.1*/
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
/*End Question 4.1*/

/*Begin Question 4.2*/
north_east(NQ,N) :-
        NQ = 1,
        between(0,90,N).
south_east(NQ,N) :-
        NQ = 2,
        between(91,180,N).
south_west(NQ,N) :-
        NQ = 3,
        between(181,270,N).
north_west(NQ,N) :-
        NQ = 4,
        between(271,359,N).

% convert quadrant into bearing.
qtn(XQ,X) :-
	north_east(XQ,X);
	south_east(XQ,X);
	south_west(XQ,X);
	north_west(XQ,X).

% convert three bearing into quadrant.
quadrant_to_num(XQ,YQ,ZQ,X,Y,Z) :-
	qtn(XQ,X),
	qtn(YQ,Y),
	qtn(ZQ,Z).

% given three numbers, compare whether they are prime or not.
xyz_not_prime(X,Y,Z) :-
	not(prime(X)),
	not(prime(Y)),
	not(prime(Z)).

possible(X,Y,Z) :-
	between(0,359,X),
        between(0,359,Y),
        between(0,359,Z),
        X =\= Y,
        X =\= Z,
        Y =\= Z.

/*End Question 4.2*/


/*Begin Question 4.3*/
% accumulator convert a num into a list of digits.
num_list_acc(0,A,A) :- !.
num_list_acc(X,OldAcc,L) :-
	XLast is X mod 10,
	append(OldAcc,[XLast],NewAcc),
	XRemain is X // 10,
	num_list_acc(XRemain,NewAcc,L).

% wrapper
num_list(X,L) :- num_list_acc(X,[],L).

% convert three three-digits number into a list of 9 elements.
three_num_list(X,Y,Z,LR) :-
	num_list(X,L1),
	num_list(Y,L2),
	num_list(Z,L3),
	append(L1,L2,LT),
	append(LT,L3,LR).
	

% find whether list contains number 1 to X
contains(0, _) :- !.

contains(X, List) :-
    member(X, List),
    NewX is X - 1,
    contains(NewX, List).

% find whether list contains number 1 to 9
list_contains_1to9(List) :- contains(9, List).

% given three numbers, find them in an ascending order or not.
ascending_order(X,Y,Z) :-
	X < Y,
	Y < Z.

different_quadrants(X,Y,Z) :-
	quadrant_to_num(XQ,YQ,ZQ,X,Y,Z),
	XQ =\= YQ,
	XQ =\= ZQ,
	YQ =\= ZQ.


acceptable(X,Y,Z) :-
    ascending_order(X,Y,Z),
    xyz_not_prime(X,Y,Z),
	different_quadrants(X,Y,Z),
	three_num_list(X,Y,Z,L),
	list_contains_1to9(L).
    

trait(X,Y,Z) :-
	possible(X,Y,Z),
	acceptable(X,Y,Z).
/*End Question 4.3*/

% factorial
% base case
factorial(0, 1) :- !.
factorial(Num, Result) :-
	% update the recursion variable
	Num_next is Num - 1,
	factorial(Num_next, Result_next),
	% update the result variable
	Result is Result_next * Num.

% sum of a list
sumlist([], 0).
sumlist([H | T], R) :-
	sumlist(T, R_next), 
	R is R_next + H.

% max element in a list
%max of list
max_l([X],X) :- !, true.
max_l([X|Xs], M):- max_l(Xs, M), M >= X.
max_l([X|Xs], X):- max_l(Xs, M), X >  M.

memberlist(X, [X | _]).
memberlist(X, [_ | T]) :-
	memberlist(X, T).

reverselist([], []).
reverselist([H | T], Result) :-
	reverselist(T, W),
	append(W, [H], Result).

% sort
insertlist(E, [], [E]).
insertlist(E, [H|T], [E,H|T]) :- E < H.
insertlist(E, [H|T], [H|W]) :- E >= H, insertlist(E, T, W).

isort([], []).
isort([H|T],V) -:
	isort(T, W),
	insertlist(H, W, V).


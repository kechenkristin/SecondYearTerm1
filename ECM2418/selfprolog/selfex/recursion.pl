% Length of a list
% base case
mylength([], 0) :- !.
mylength([_ | X], Result) :-
	% update recursion variable
	length(X, Result_next),
	% update result variable
	Result is Result_next + 1.

% Sum of a list of numbers
% base case
sum_list([], 0) :- !.
sum_list([H | T], Result) :-
	% update the recursion variable
	sum_list(T, Result_next),
	% update the result variable
	Result is H + Result_next.

% factorial
% base case
factorial(0, 1) :- !.
factorial(Num, Result) :-
	% update the recursion variable
	Num_next is Num - 1,
	factorial(Num_next, Result_next),
	% update the result variable
	Result is Result_next * Num.

% max element in a list
% helper function
% base case
max_helper([], R, R) :- !.
max_helper([X | XS], Y, R) :- X > Y, max_helper(XS, X, R).
max_helper([X | XS], Y, R) :- X =< Y, max_helper(XS, Y, R).
max_list([X | XS], R) :- max_helper(XS, X, R).

memberlist(_, []) :- false.
memberlist(Y, [X | XS]) :-
	Y = X, true, !.
memberlist(Y, [X | XS]) :-
	Y != X, memberlist(Y, XS).

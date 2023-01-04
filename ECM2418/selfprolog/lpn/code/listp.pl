% X is an element of List
mymember(X,[X|_]).
mymember(X,[_|Y]) :- mymember(X,Y).

myappend([], Y, Y).
myappend([H | X], Y, [H | Z]) :- myappend(X, Y, Z).

swap_first_two([X, Y | Rest], [Y, X | Rest]).

mylength([], 0).
mylength([_|X],R) :- mylength(X,Rnext), R is Rnext + 1.

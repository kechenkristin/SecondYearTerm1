% slides examples
addThreeAndDouble(X,Y) :- Y is (X+3)*2.

% length of list
% tail recursion
acclen([],Acc,Acc).
acclen([_|L],OldAcc,Length):-
	NewAcc is OldAcc + 1,
	acclen(L,NewAcc,Length). 

% wrapper
mylength(L,Len) :- acclen(L,0,Len).

% finding the max value in a list
accMax([],A,A).

accMax([H|T],A,Max) :-
	H>A,
	accMax(T,H,Max).
accMax([H|T],A,Max) :-
	H =< A,
	accmax(T,A,Max).

% wrapper
mymax([H|T],Max) :- accMax(T,H,Max).

% not tail recurion
len([],0).
len([_|L],NewLen) :-
	len(L,Len),
	NewLen is Len + 1.

% exercise
% Define a 2-place predicate increment that holds only when its second argument is an integer one larger than its first argument. For example, increment(4,5) should hold, but increment(4,6) should not.
increment(X,Y) :- Y is X+1.

% Define a 3-place predicate sum that holds only when its third argument is the sum of the first two arguments. For example, sum(4,5,9) should hold, but sum(4,6,12) should not.
sum(X,Y,Z) :- Z is X+Y.

% Write a predicate addone/2 whose first argument is a list of integers, and whose second argument is the list of integers obtained by adding 1 to each integer in the first list. For example, the query
% ?-  addone([1,2,7,2],X).
% X  =  [2,3,8,3].
addone([],[]).
addone([H1|T1],[H2|T2]) :- H2 is (H1+1),addone(T1,T2).


% practical session
% In the text we discussed the 3-place predicate accMax which returned the maximum of a list of integers. By changing the code slightly, turn this into a 3-place predicate accMin which returns the minimum of a list of integers.
accMin([],A,A).

accMin([H|T],A,Min) :-
	H >= A,
	accMin(T,A,Min).
accMin([H|T],A,Min) :-
	H < A,
	accMin(T,H,Min).

mymin([H|T],Min) :- accMin(T,H,Min).

% Write a 3-place predicate scalarMult whose first argument is an integer, whose second argument is a list of integers, and whose third argument is the result of scalar multiplying the second argument by the first. 
% ?-  scalarMult(3,[2,7,4],Result).
% Result  =  [6,21,12]
scalarMult(_,[],[]).

scalarMult(X,[H1|T1],[H2|T2]) :-
	H2 is X * H1,
	scalarMult(X,T1,T2).

% Write a 3-place predicate dot whose first argument is a list of integers, whose second argument is a list of integers of the same length as the first, and whose third argument is the dot product of the first argument with the second. For example, the query
% ?-  dot([2,5,6],[3,4,1],Result).
% Result  =  32 % 6 + 20 + 6
accdot([],[],R,R).

accdot([H1|T1],[H2|T2],OldAcc,R) :-
	NewAcc is OldAcc + H1 * H2,
	accdot(T1,T2,NewAcc,R).

dot([H1|T1],[H2|T2],R) :- accdot(T1,T2,H1*H2,R).

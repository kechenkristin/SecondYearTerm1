% slides
myappend([],L,L).
myappend([H1|T1],L2,[H1|T3]) :- myappend(T1,L2,T3).

% use of append
% splitting up a list

% prefix
prefix(P,L) :- myappend(P,_,L).

% suffix
suffix(S,L) :- myappend(_,S,L).

% sublist
sublist(Sub,List) :-
	suffix(Suffix,List),
	prefix(Sub,Suffix).

% native reverse in prolog
nativeReverse([],[]).
nativeReverse([H|T],R) :-
	nativeReverse(T,RT),
	append(RT,[H],R).

% reverse using an accumulator
accReverse([],L,L).
accReverse([H|T],Acc,Rev) :- accReverse(T,[H|Acc],Rev).

reverse(L1,L2) :- accReverse(L1,[],L2).

% exercise
% 6.1
doubled(List) :- myappend(X,X,List).

% 6.2
palindrome(List) :- reverse(List,List).

% 6.3
toptail(InList,OutList) :- myappend([_|OutList],[_],InList).

% 6.4
last(List,X) :- reverse(List,[X|_]).

lastre([X],X).
lastre([_|T],X) :- lastre(T,X).

% 6.5
swapfl([], []).
swapfl([First1|Tail1], [First2|Tail2]):-
	reverse(Tail1, [Last1|Rest1]),
	reverse(Tail2, [Last2|Rest2]),
	First1 = Last2,
	Last1 = First2,
	Rest1 = Rest2.

myswapfl(L1,L2) :- 
	myappend([L1First|SamePart],[L1Last],L1),
	myappend([L1Last|SamePart],[L1First],L2).

% practical
mymember(X,L) :- myappend(_,[X|_],L).

setAcc([],A,A).
setAcc([H|T],AccS,S) :-
	mymember(H,AccS),
	setAcc(T,AccS,S).
setAcc([H|T],AccS,S) :-
	not(mymember(H,AccS)),
	setAcc(T,[H|AccS],S).

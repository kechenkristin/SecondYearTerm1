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

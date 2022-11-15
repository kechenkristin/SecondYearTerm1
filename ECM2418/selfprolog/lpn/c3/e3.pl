% exercise 3.2
% directlyin/2
directlyin(katarina,olga).
directlyin(olga,natasha).
directlyin(natasha,irina).

% in/2
in(X,Y) :- directlyin(X,Y).
in(X,Y) :-
	directlyin(X,Z),
	in(Z,Y).

% exercise 3.3
directTrain(saarbruecken,dudweiler).
directTrain(forbach,saarbruecken).
directTrain(freyming,forbach).
directTrain(stAvold,freyming).
directTrain(fahlquemont,stAvold).
directTrain(metz,fahlquemont).
directTrain(nancy,metz).

travelFromTo(X,Y) :- directTrain(X,Y).
trevelFromTO(X,Y) :-
	directTrain(X,Z),
	travelFromTo(Z,Y).

% 3.4
greater_than(succ(_),0).
greater_than(succ(X),succ(Y)) :-
	greater_than(X,Y).

% 3.5
swap(leaf(X),leaf(X)).
swap(tree(X,Y),tree(SwappedY,SwappedX)) :-
	swap(X,SwappedX),
	swap(Y,SwappedY).

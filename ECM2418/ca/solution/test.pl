grid(L1,[H2|T2],L3) :-
append(L1,[H2],NewL1),
append(NewL1,T2,L3).

takeout(X,[X|R],R).
takeout(X,[F |R],[F|S]) :- takeout(X,R,S).

perm([X|Y],Z) :- perm(Y,W), takeout(X,Z,W).
perm([],[]).

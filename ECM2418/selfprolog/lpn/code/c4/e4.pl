mymember(X,[X|_]).
mymember(X,[_|T]) :- mymember(X,T).

a2b([],[]).
a2b([a|L1],[b|L2]) :- a2b(L1,L2).

% 4.3
% Write a predicate second(X,List) which checks whether X is the second element of List .
second(X,List) :- List=[_,X|_].

% 4.3
%  Write a predicate swap12(List1,List2) which checks whether List1 is identical to List2 , except that the first two elements are exchanged.
swap12(List1,List2) :- List1=[L1a,L1b|T], List2=[L1b,L1a|T].

% 4.4
tran(eins,one).
tran(zwei,two).
tran(drei,three).
tran(vier,four).
tran(fuenf,five).
tran(sechs,six).
tran(sieben,seven).
tran(acht,eight).
tran(neun,nine).

listtran([],[]).
listtran([G|GT],[E|ET]) :-
	tran(G,E),
	listtran(GT,ET).

% 4.5
twice([],[]).
twice([Ha|Ta],[Ha,Ha|Tb]) :- twice(Ta,Tb).

% Write a 3-place predicate combine1 which takes three lists as arguments 
% and combines the elements of the first two lists into the third as follows:
% ?- combine1([a,b,c],[1,2,3],X).
% X = [a,1,b,2,c,3]
% ?- combine1([f,b,yip,yup],[glu,gla,gli,glo],Result).
% Result = [f,glu,b,gla,yip,gli,yup,glo]

combine1([],[],[]).
combine1([H1 | T1], [H2 | T2], [H1, H2 | T3]) :- combine1(T1, T2, T3).


% Now write a 3-place predicate combine2 which takes three lists as arguments and combines the elements of the first two lists into the third as follows:
% ?- combine2([a,b,c],[1,2,3],X).
% X = [[a,1],[b,2],[c,3]]
% ?- combine2([f,b,yip,yup],[glu,gla,gli,glo],Result).
% Result = [[f,glu],[b,gla],[yip,gli],[yup,glo]]

combine2([],[],[]).
combine2([H1|T1],[H2|T2],[[H1,H2]|T3]) :- combine2(T1,T2,T3).

% Finally, write a 3-place predicate combine3 which takes three lists as arguments and combines the elements of the first two lists into the third as follows:
% ?- combine3([a,b,c],[1,2,3],X).
% X = [j(a,1),j(b,2),j(c,3)]
% ?- combine3([f,b,yip,yup],[glu,gla,gli,glo],R).
% R = [j(f,glu),j(b,gla),j(yip,gli),j(yup,glo)]

combine3([],[],[]).
combine3([H1|T1],[H2|T2],[j(H1,H2)|T3]) :- combine3(T1,T2,T3).

%% 1. Write a predicate mysubset/2 that takes two (unsorted?) lists (of
%% constants) as arguments and checks, whether the first list is a subset of the
%% second.

mysubset([],_).
mysubset([H1 | T1], T2) :-
  member(H1, T2),
  mysubset(T1, T2).

%% 2. Write a predicate mysuperset/2 that takes two (unsorted?) lists as
%% arguments and checks, whether the first list is a superset of the second.

mysuperset(_,[]).
mysuperset(T1, [H2 | T2]) :-
  member(H2, T1),
  mysuperset(T1, T2).

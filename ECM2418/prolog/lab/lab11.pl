word(and).
word(ass).
word(bad).
word(cold).
word(or).
word(pie).
word(shoe).
word(wit).

oddEvens([],[],[]).
oddEvens([H],[H],[]).
oddEvens([H1,H2|T],[H1|T1],[H2|T2]) :-
	oddEvens(T, T1, T2).

alternade(C) :-
	name(C,X),
	oddEvens(X,O,E),
	name(OW,O),
	name(EW,E),
	word(OW),
	word(EW).




animal(aardvark).
animal(antelope).
animal(coyote).
animal(donkey).
animal(elephant).

vegetable(cabbage).
vegetable(carrot).
vegetable(celery).
vegetable(leek).
vegetable(lerruce).

mineral(basalt).
mineral(cobolt).
mineral(copper).

solution(R) :-
	animal(A),
	name(A, [X4,X5,X2,X5,X8,X9]),
	vegetable(V),
	name(V,[X6,X5,X8,X7,X8,X5]),
	mineral(M),
	name(M,[X7,X3,X7,X8,X7,X1,X9]),
	solution(R,[X1,X2,X3,X4,X5,X6,X7,X8,X9]).

factorial_acc(0,1,1) :- !.
factorial_acc(Num,OldAcc,R) :-
	NewAcc is Num * OldAcc,
	factorial_acc(Num - 1, NewAcc, R).

factorial(Num, R) :- factorial_acc(Num, 1, R).

add(X,Y,Z) :- Z is X + Y.

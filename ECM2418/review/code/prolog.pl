%% lab1
factorial ( 0 , 1 ) .
factorial ( N , F ) : -
	N1 is N - 1 ,
	factorial ( N1 , F1 ) ,
	F is N * F1 .

sumlistAcc([],Acc,Acc) :- !. 
sumlistAcc([H|T],OldAcc,R) :-	
	NewAcc is OldAcc+H,
	sumlistAcc(T,NewAcc,R).

sumlist(L,X) :- sumlistAcc(L,0,X).

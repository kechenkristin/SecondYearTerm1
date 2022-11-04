parent(david,jeremy).
parent(david,peter).
parent(david,simon).
parent(pat,jeremy).
parent(pat,peter).
parent(pat,simon).
parent(jeremy,william).
parent(jeremy,tim).
parent(jeremy,josephine).
parent(sandra,william).
parent(sandra,tim).
parent(sandra,josephine).
parent(peter,rosemary).
parent(peter,jonathan).
parent(carol,rosemary).
parent(carol,jonathan).
parent(simon,miranda).
parent(simon,emily).
parent(clare,miranda).
parent(clare,emily).

male(david).
male(jeremy).
male(peter).
male(simon).
male(william).
male(tim).
male(jonathan).

female(pat).
female(sandra).
female(carol).
female(clare).
female(rosemary).
female(josephine).
female(miranda).
female(emily).

father(X,Y) :- male(X), parent(X,Y).
mother(X,Y) :- female(X), parent(X,Y).

grandparent(X, Y) :- parent(X, Z), parent(Z, Y).

son(X, Y) :- male(X), parent(Y, X).
daughter(X, Y) :- female(X), parent(Y, X).

grandfather(X,Y) :- father(X,Z), parent(Z,Y).
grandmother(X,Y) :- mother(X,Z), parent(Z,Y).
grandson(X,Y) :- male(X), grandparent(Y,X).
granddaughter(X,Y) :- female(X), grandparent(Y,X).

ancestor(X, Y) :- parent(X, Y).
ancestor(X, Y) :- parent(X, Z), ancestor(Z, Y).

sibling(X, Y) :- father(Z, X), father(Z, Y), mother(W, X), mother(W, Y), X \== Y.

brother(X, Y) :- male(X), sibling(X, Y).
sister(X, Y) :- female(X), sibling(X, Y).

uncle(X, Y) :- brother(X, Z), parent(Z, Y).
aunt(X, Y) :- sister(X, Z), parent(Z, Y).

cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).

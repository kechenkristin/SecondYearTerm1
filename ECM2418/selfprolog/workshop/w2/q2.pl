flies(X) :- bird(X), \+flightless(X).
flightless(X) :- ostrich(X).
bird(X) :- ostrich(X).
bird(X) :- canary(X).
ostrich(oliver).
canary(tweety).

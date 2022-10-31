hungry.
raining.
no_food.
no_tiles.
no_umbrella.
get_wet :- raining, leaky_roof.
get_wet :- raining, go_out, no_umbrella.
go_out :- need_tiles.
go_out :- need_food.
need_tiles :- leaky_roof, no_tiles.
need_food :- hungry, no_food.
leaky_roof :- false.

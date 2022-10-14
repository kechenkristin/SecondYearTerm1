import random

def load_puzzle(name):
  """
  Loads puzzle from text file in specified format
  Returns 2D array of elements
  """
  
  puzzle = []

  with open(f"./grids/Grid{name}.ss") as grid:
    for line in grid:
      line = line.strip()

      if line.startswith("-"):
        continue

      for section in line.split("!"):
        for value in list(section):
          if value != ".":
            puzzle.append(int(value))
          else:
            puzzle.append(0)

  return [puzzle[i:i + 9] for i in range(0, len(puzzle), 9)]


def get_row(puzzle, idx):
  """
  Return row from sudoku puzzle
  """
  
  return puzzle[idx]
  
  
def get_column(puzzle, idx):
  """
  Return column from sudoku puzzle
  """
  
  column = []
  for i in puzzle:
    column.append(i[idx])
    
  return column
   
    
def get_box(puzzle, x, y):
  """
  Return box from sudoku puzzle
  """
  
  n = int(len(puzzle) ** 0.5)
  box = []  
  for i in range(x * n, (x * n) + n):
    box.append([])
    
    for j in range(y * n, (y * n) + n):
      box[-1].append(puzzle[i][j])
  
  return box


def sudoku_fitness(puzzle):
  """
  Calculates fitness based on number of unique values in 
  columns, rows and boxes
  """
  
  n = len(puzzle)

  fitness = {
    "col": 0,
    "row": 0,
    "box": 0
  }
  
  # column fitness
  for i in range(len(puzzle)):
    col = get_column(puzzle, i)
    fitness["col"] += len(set(col)) # number of unique values
  
  fitness["col"] /= n # divide by number of columns
    
  # row fitness 
  for i in range(len(puzzle)):
    row = get_row(puzzle, i)
    fitness["row"] += len(set(row)) # number of unique values
  
  fitness["row"] /= n # divide by number of rows

    
  # box fitness
  for i in range(int(n ** 0.5)):
    for j in range(int(n ** 0.5)):
      box = get_box(puzzle, i, j)
      flat_box = [item for sublist in box for item in sublist]
      fitness["box"] += len(set(flat_box)) # number of unique values
    
  fitness["box"] /= n # divide by number of boxes
      
  total_fitness = fitness["col"] + fitness["row"] + fitness["box"]
  total_fitness /= (n * 3) # divide by number of fitnesses
  
  return total_fitness


def print_puzzle(puzzle):
  """
  Prints puzzle row by row
  """
  
  for row in puzzle:
    print(row)
    
def copy(puzzle):
  """
  Creates a duplicate object of the puzzle
  """
  
  new_puzzle = []
  
  for i in range(0, len(puzzle)):
    new_puzzle.append([])
    
    for j in range(0, len(puzzle[i])):
      new_puzzle[i].append(puzzle[i][j])
      
  return new_puzzle


def generate(puzzle):
  """
  Fill partially empty sudoku puzzle with missing numbers
  from the puzzle (9 of each number)
  """
  
  new_puzzle = copy(puzzle)
  missing = []
  
  for row in new_puzzle:
    for i in range(1, len(new_puzzle) + 1):
      if i not in row:
        missing.append(i)
       
  
  for i in range(0, len(new_puzzle)):
    for j in range(0, len(new_puzzle)):
      if new_puzzle[i][j] == 0:
        choice = random.choice(missing)
        missing.remove(choice)
        new_puzzle[i][j] = choice
        
  return new_puzzle


def start(puzzle, population):
  """
  Create the initial population for a evolution to occur
  """
  
  puzzles = []
  for _ in range(population):
    attempted_solution = generate(puzzle)
    puzzles.append(attempted_solution)
    
  return puzzles


def get_pairs(candidates):
  """
  Generate the parent pairs within the remaining population
  """
  
  pairs = []
  
  for _ in candidates:   
    pairs.append([random.choice(candidates), random.choice(candidates)])
  
  return pairs
        
        
def cross(pair, crossover_rate):
  l = copy(pair[0])
  r = copy(pair[1])
  
  if random.uniform(0, 1) <= crossover_rate:
    for i in range(len(l)):
      k = random.randrange(0, len(l))
      l[i] = l[i][:k] + r[i][k:]
      r[i] = r[i][:k] + l[i][k:]
    
  return l, r


def mutate(puzzle, original, mutation_rate):
  """
  Swap two random numbers on the sudoku puzzle if they are moveable
  """
  
  mutation = copy(puzzle)
  
  for i in range(len(mutation)):    
    for j in range(len(mutation)):
      if original[i][j] == 0:
        if random.uniform(0, 1) <= mutation_rate:
          x = random.randrange(0, len(mutation))
          y = random.randrange(0, len(mutation))
          
          if original[x][y] == 0:
            temp = mutation[i][j]
            mutation[i][j] = mutation[x][y]
            mutation[x][y] = temp
      
  return mutation


if __name__ == "__main__":
  """
  Settings for evolution
  """
  
  POPULATION = 10000 # initial number to pópulate with
  CROSSOVER_RATE = 0.95 # chance of crossover
  MUTATION_RATE = 1/52 # chance of mutatations
  MAX_GENERATION = 500 # when to quit if goal is not met
  PUZZLE_ID = 3 # which puzzle to select (1-3)
  
  generation = 0
  puzzle = load_puzzle(PUZZLE_ID)
  candidates = start(puzzle, POPULATION)

  while candidates:
    candidates.sort(key=lambda x: sudoku_fitness(x), reverse=True)
    
    if sudoku_fitness(candidates[0]) == 1:
      print(f"DONE IN {generation} GENERATIONS")
      print_puzzle(candidates[0])
      break
    
    if generation == MAX_GENERATION:
      print_puzzle(candidates[0])
      break
      
    generation += 1
    avg_fitness = sum([sudoku_fitness(i) for i in candidates]) / POPULATION
    print(f"Generation {generation} - Max: {sudoku_fitness(candidates[0])} Average: {avg_fitness}")
    
    candidates = candidates[:POPULATION // 2]
    pairs = get_pairs(candidates)

    candidates = []

    for pair in pairs:
      for child in cross(pair, CROSSOVER_RATE):
        if child:
          mutation = mutate(child, puzzle, MUTATION_RATE)
          candidates.append(mutation)

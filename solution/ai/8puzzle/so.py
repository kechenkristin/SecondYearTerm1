 # goal:     {1,2,3,4,5,6,7,8,0}
# 6 steps:  {1,3,5,4,0,2,7,8,6}
# 18 steps: {1,4,0,5,2,8,7,6,3}
# 26 steps: {2,1,7,5,0,8,3,4,6}
# 27 steps: {8,5,3,4,7,0,6,1,2}
# 28 steps: {0,6,7,3,8,5,4,2,1}
# 30 steps: {5,7,0,4,6,8,1,2,3}
# 31 steps: {8,6,7,2,5,4,3,0,1}
import time
start_time = time.time()

"""
Define the start and goal states
"""
start_state = [[7, 2, 4], 
              [5, 0, 6],
              [8, 3, 1]]

goal_state = [[0, 1, 2], 
              [3, 4, 5],
              [6, 7, 8]]


class Node:
  """
  Node class to store state, g and f values
  """
  
  def __init__(self, data, g=0, f=0):
    self.data = data
    self.g = g
    self.f = f

  def generate(self):
    """
    Obtain the possible moves from the current state
    """
    
    children = []
    
    # find blank tile
    x, y = search(self.data, 0)
    
    #                   right         up         left        down
    possible_moves = [[x + 1, y], [x, y + 1], [x - 1, y], [x, y - 1]]

    # attempt to make the 4 legal moves 
    for i in possible_moves:
      move = make_move(self.data, [x, y], i)
      if move:
        child = Node(move, self.g + 1)
        children.append(child)
        
    return children
        
def copy(state):
  """
  Create a deep copy of the state array
  """
  
  new_state = []
  
  for i in range(0, len(state)):
    new_state.append([])
    
    for j in range(0, len(state[i])):
      new_state[i].append(state[i][j])
      
  return new_state
  

def make_move(state, current, new):
  """
  Make a move from current to new positions if they are legal
  """
  
  # check if new position is inside the puzzle
  if new[0] >= 0 and new[0] < len(state) and new[1] >= 0 and new[1] < len(state):
    temp_state = copy(state)    
    temp = temp_state[new[0]][new[1]]
    temp_state[new[0]][new[1]] = temp_state[current[0]][current[1]]
    temp_state[current[0]][current[1]] = temp

    return temp_state

def hamming(state, goal):
  """
  Calculate hamming distance between state and goal
  """
  
  h_value = 0

  for i in range(0, len(state)):
    for j in range(0, len(state[i])):
      if state[i][j] != goal[i][j] and state[i][j] != 0:
        h_value += 1

  return h_value

def manhattan(state, goal):
  """
  Calculate manhattan distance between state and goal
  """
  
  h_value = 0
  
  # values: 1 - 8
  for num in range(1, 9):
    x, y = search(state, num)
    i, j = search(goal, num)
    h_value += abs(x - i) + abs(y - j)
        
  return h_value


def f(node, h):
  """
  f(n) = h(n) + g(n)
  """
  
  return h(node.data, goal_state) + node.g


def search(state, value):
  """
  Find x, y values of tile in puzzle 
  """
  
  for i in range(0, len(state)):
      for j in range(0, len(state[i])):
        if state[i][j] == value:
          return i, j


def solvable(state):
  """
  Calculate number of inversions in the puzzle, if the 
  number is even, then the puzzle is solvable
  """
  
  count = 0
  flat_state = [item for sublist in state for item in sublist]
  for i in range(0, len(flat_state)):
    for j in range(i + 1, len(flat_state)):
      if flat_state[j] != 0 and flat_state[i] != 0 and flat_state[i] > flat_state[j]:
        count += 1

  return count % 2 == 0


if __name__ == '__main__':
  attempts = 0
  h_func = manhattan # hamming or manhattan
  
  if solvable(start_state):
    open_states = []
    closed_states = []
    
    start_node = Node(start_state)
    start_node.f = f(start_node, h_func)
    open_states.append(start_node)
      
    while open_states:
      attempts += 1
      current_state = open_states.pop(0)      
      closed_states.append(current_state.data)
      
      h_value = h_func(current_state.data, goal_state)
      
      if h_value == 0:
        print(f"DONE IN {attempts} ATTEMPTS")
        print(f"WILL TAKE {current_state.g} STEPS")
        print(f"TOOK {time.time() - start_time}s")
        print(current_state.data)
        break
      
      for i in current_state.generate():
        if i.data not in closed_states:
          i.f = f(i, h_func)
          open_states.append(i)
          
      open_states.sort(key=lambda x: x.f)
  else:
    print("NOT SOLVABLE")

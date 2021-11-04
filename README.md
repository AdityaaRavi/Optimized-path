# Optimized-path
In this repo, I try to create a program that finds a path which minimizes/maximizes the given parameter, starting with collisions; with a special focus on emphasizing OOP principles.

# A bit more detailed description of what I want to do here: #

I want to create a java program/API that takes in input from a text file about a `board` that can represent a maze/forest/what not; a starting position (`sx`,`sy`); and a parameter to minimize/maximize [I will refer to it as "optimize" from here on] (for example the number of collisions with a given object).

As an example, I including an algorithm that minimizes the number of collisions with a `tree` - represented by the character "#" in the `board`, that uses and builds on the API to show how easy it is to make changing the path finding algorithm, or the goal of the path finding algorithm, or really anything to specialize your specific program as simple as creating a subclass and overloading a method.

# The entire program explained #
There are 6 things to want I want to do here:

- __Part 1: Getting the board ready:__
  To be able to test the algorithm I end up making, I need to have sample inputs first. To that end, I am going to make a python program that will take in the characters to use as `trees` and the size of the board, and use that information to create a `board` on which the the path finding algorithm will do its magic. (DONE!)
 
- __Part 2:__ Creating a class that can ingest information from the board and return it to `main()` in the format needed to make my life easy when I code the actual algorithm. (DONE!)

- __Part 3:__ Creating the class (`Algorithm<E>`) that carries out the actual algorithm. (DONE!) (But more must be done to improve efficiency)

- __Part 4:__ Create a class that takes the output of the actual algorithm and writes it on a text file to make it easy to visualize the results. (DONE!)

- __Part 5:__ Think about different ways this algorithm can be made more efficient. I do have a few ways in mind for the same, so I might just spend the rest of my winter break on this... lets see. I would imagine it would take a lot less coding and a lot more thinking; now that I have all other parts of the code done.

- __Part 6:__ Once all that is done, update `README.md` to reflect what classes do what and provide all the information a random fellow Computer Scienist will need to use my program as an API for whatever they do.


## The actual algorithm ##

- The algorithm is actually quite simple -- the whole algorithm is going to be in a single recursive method. Inside that method, we are going to have 5 base cases (see the section below) and a for loop that makes a recursive call -- one for every possible movement within the `board` (see its respective section). 
- The `Algorithm<E>` class will have a parameter to keep track of the number of occurances (`num_occur`) of the variable to optimize (see base case no. 2) and a parameter (`curr_path`) that keeps track of the path taken in your current branch. 
- The class will also be two other parameters variables: `best_num_occur`, which stores the `num_occur` of the most optimized path found yet and the `best_path` which is a ` ArrayList<Integer[3]>` with each of the `Integer[3]` containing the `x` and `y` positions of each cell visited in the best path, along with the `num_occur` of that recursive call. (see the section about variable references for more info).
- The method will also return different things based on if it had found a new and better path, or if it had terminated in the middle after having found that the current branch is a dead branch (see base case no. 2 and the return values section). 

___Base cases:___

1.  The first base case is the obvious one -- This case checks if we have reached the end of the `board`. This returns the `path_found` token (see return values section) and then updates the `best_path` with `curr_path`.
2.  The second base case needs an explainer -- as we are keeping track of `best_num_occur` and the `num_occur` of the current branch, it is quite easy to find out if the current path still has a chance of changing the `best_path`: If we are minimizing a variable, then if the `num_occur` is larger than the `best_num_occur`, it is useless to continue with the current branch, as its outcome cannot change the `best_path` or the `best_num_occur` -- the vice versa applies if you are trying to minimize a variable. If the current branch is found to be dead based on this criteria, the `dead_path` token is returned (see the return values section).
3. If the `best_num_occur` at any point is found to be zero, that means that the best possible path has been found (barring other equally good paths, but we don't care about that here), thus we can safely quit. 
4. If you reached a cell that you have previously processed (and thus is in `curr_path`), quit the current recursive call to prevent a stack overflow. _(The checking will be done in an overloaded method, so if this is not relevant to your application aka you know that it is impossible to come back to a visited position within the same branch, you may overload this method to always return `false` thus avoiding the expensive operation of searching)_
5. If you reached a cell in your current branch that is already a part of the best path, then find out the `num_occur` of the `best_path` following the occurance of the said cell (i.e `best_num_occur` - `num_occur` of the said cell), add it to the `num_occur` of the _current branch_ to find the `num_occur` the current branch _would_ have if it reached the end. This way you can avoid processing a result you already know. This might actually have a huge efficieny boost when processing a large `board`.
___Dependencies for this to work:___ Keep track of `num_occur` of each recursive call in the `curr_path` and `best_path` ArrayLists. 


___Possible movements in the `board`:___

There will be an abstract method in the algorithm class whose job it is to return an `ArrayList<Integer[2]>` with each of the `Integer[2]` containing the `dx` and `dy` values of one of the possible movements that the algorithm can make (see section about sign convention for more info). This method will be called once in the constructor of the `Algorithm<E>` class' subclass and the possible movements will be stored as a parameter. The recursive method will use a for-each loop where a recursive call is made for each of the possible positions from the said parameter.

___Possible Return values of the function:___

- `path_found` = 1
- `dead_path` = -1


___Variable references:___
- `x` - starts at 0, increases as you go left (see below)
- `y` - starts at 0, increases as you go down (see below)

___Sign convention used:___

- Towards the floor = `+dy`
- Towards the roof = `-dy`
- Towards Left = `-dx`
- Towards right = `+dx`

# Example Output #
This is the output for the example described in the introduction.
![image](https://user-images.githubusercontent.com/43429374/112085514-e7090900-8b47-11eb-92ef-93b3b4a86d89.png)

# Current progress: #

__Done:__
- Program needed to generate a random `board` done.
- Runner class with the `main()` method that calls each of these individual methods for the `Forest` example done.
- Code needed to ingest information from the file used to store the said randomly generated `board` done.
- Algorithm class overall structure done
- `Algorithm<E>`, `ingest<E>` and `Show<E>` classes converted to use generics instead of a specific type for storing the board.
- The first three base cases have been implemented in the `Algorithm<E>` class.
- Code needed to take the result from the algorithm and show it in a readable way completed.
- The `Forest` example on how to use this as an API fully done.

__TO DO:__
- Implement the remaing two base cases that are currently planned.
- Think about any other base cases that can measurably reduce the time complexity.
- Create a `shell` program to help with measuring the time complexity. 
- Try using a __single__ global array for `curr_path` that is shared by all branches instead of creating a copy of the `curr_path` everytime a recursive call is made - possibly triming down the memory complexity without affecting the time complexity by passing the index of where a recursive call diverged from the parent branch rather than a copy of the entire path taken from the starting point to the current cell.

# Optimized-path
In this repo, I try to create an algorithm that finds a path that minimizes/maximizes the given parameter, starting with collisions.

## A bit more detailed description of what I want to do here: ##

I want to create a java program/API that takes in input from a text file about a `board` that can represent a maze/forest/what not; a starting position (`sx`,`sy`); and a parameter to minimize/maximize [I will refer to it as "optimize" from here on] (for example the number of collisions with a given object).

I am inital going to work on an algorithm that minimizes the number of collisions with a `tree` - represented by the character "#" in the `board`, but while I am at it, use OOP concepts to make changing the path finding algorithm, or the goal of the path finding algorithm, or really anything relvant as simple as creating a subclass and overloading a method.

## The entire program explained ##
### There are 6 things to want I want to do here:

- __Part 1: Getting the board ready:__
  To be able to test the algorithm I end up making, I need to have sample inputs first. And since I am not a masochist, I am going to make a python program that will take in the characters to use as `trees` and the size of the board, and use that information to create a `board` on which the the path finding algorithm will do its magic. (DONE!)
 
- __Part 2:__ Creating a class that can ingest information from the board and return it to `main()` in the format needed to make my life easy when I code the actual algorithm. (DONE!)

- __Part 3:__ Creating the class (`Algorithm`) that carries out the actual algorithm. (Debug in progress)

- __Part 4:__ Create a class that takes the output of the actual algorithm and writes it on a different text file in a way us puny humans will be able to easily understand. (DONE!)

- __Part 5:__ Once all that is done, update `README.md` to reflect what classes do what and provide all the information a random fellow Computer Scienist will need to use my program as an API for whatever they do.

- __Part 6:__ If time permits (looking at what task I took, I probably won't), create a GUI using JavaFX or something modern to make it easier to use my program.

## The actual algorithm ##

"Recursion is nice"

- The algorithm is actually quite simple -- the whole algorithm is going to be in a single recursive method. Inside that method, we are going to have three base cases (see the section below) and a for loop that makes a recursive call -- one for every possible movement within the `board` (see its respective section). 
- The `Algorithm` class will have a parameter to keep track of the number of occurances (`num_occur`) of the variable to optimize (see base case no. 2) and a parameter (`curr_path`) that keeps track of the path taken in your current branch. 
- The class will also be two other parameters variables: `best_num_occur`, which stores the `num_occur` of the most optimized path found yet and the `best_path` which is a ` ArrayList<Integer[2]>` with each of the `Integer[2]` containing the `x` and `y` positions of each cell visited in the best path. (see the section about sign convention for more info).
- The method will also return different things based on if it had found a new and better path, or if it had terminated in the middle after having found that the current branch is a dead branch (see base case no. 2 and the return values section). 

___Base cases:___

1.  The first base case is the obvious one -- This case checks if we have reached the end of the `board`. This returns the `path_found` token (see return values section) and then updates the `best_path` with `curr_path`.
2.  The second base case needs an explainer -- as we are keeping track of `best_num_occur` and the `num_occur` of the current branch, it is quite easy to find out if the current path still has a chance of changing the `best_path`: If we are minimizing a variable, then if the `num_occur` is larger than the `best_num_occur`, it is useless to continue with the current branch, as its outcome cannot change the `best_path` or the `best_num_occur` -- the vice versa applies if you are trying to minimize a variable. If the current branch is found to be dead based on this criteria, the `dead_path` token is returned (see the return values section).
3. If the `best_num_occur` at any point is found to be zero, that means that the best possible path has been found (barring other equally good paths, but we don't care about that here), thus we can safely quit. 

___Possible movements in the `board`:___

There will be an abstract method in the algorithm class whose job it is to return an `ArrayList<Integer[2]>` with each of the `Integer[2]` containing the `dx` and `dy` values of one of the possible movements that the algorithm can make. This method will be called once in the constructor of the `Algorithm` class' subclass and the possible movements will be stored as a parameter. The recursive method will use a for-each loop where a recursive call is made for each of the possible positions from the said parameter.

___Possible Return values of the function:___

- `path_found` = 1
- `dead_path` = -1


___Variable references:___
- `x` = starts at 0, increases as you go left (see below)
- `y` = starts at 0, increases as you go down (see below)

___Sign convention used:___

- Towards the floor = `+dy`
- Towards the roof = `-dy`
- Towards Left = `-dx`
- Towards right = `+dx`

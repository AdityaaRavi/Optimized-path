# This program will make a random board based on the given parameters.
import random

file_name = input("Enter the file name of the result: ")
w, h, num_trees = 4, 4, 4 #input("Enter the width, height and the max number of trees you need each seperated by a space: ").split()
tree_char, empty_char = '#', '=' #input("Enter the char to use for denoting the obstacle and the char to denote an empty space the same way: ").split()
w, h, num_trees = int(w), int(h), int(num_trees)

board = []

def fill_board(board, w, h):
    for i in range(0, w):
        board.append([])
        for j in range(0, h):
            board[i].append(empty_char)

def print_board(board=board):
    for row in board:
        print(row)

# testing the fill_board method
# print("Testing the fill empty char method")
# fill_board(board, w, h)
# print_board()

def fill_obstacle(board, probability, w, h=h):
    curr_trees = 0
    probability *= 100
    for i in range(0, w):
        board.append([])
        for j in range(0, h):
            choice = random.choices([empty_char, tree_char], weights=[100-probability, probability], k=1)[0]
            #print("The choice picked is ", choice, " The probablity is:", probability)
            if(choice == tree_char):
                curr_trees += 1
            
            if(curr_trees <= num_trees):
                board[i].append(choice)


#testing fill obstacle in array method
print("Testing fill obstacle method: ")
fill_obstacle(board, num_trees/(w*h), w, h)
print_board()

def print_to_file(board, w, h, filename=file_name):
    file_handler = open(filename, "w")
    writeme = ""
    for i in range(0, w):
        for j in range(0, h):
            writeme += board[i][j] + " "
            print(board[i][j], end=" ")
        writeme += "\n"
        print()
    file_handler.close()

# testing print to file method
print("Testing print to file method: ")
print_to_file(board, w, h, file_name)
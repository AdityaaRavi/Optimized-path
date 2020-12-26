# This program will make a random board based on the given parameters.
import random

file_name = input("Enter the file name of the result: ")
w, h, num_trees = input("Enter the width, height and the number of trees you need each seperated by a space: ").split()
tree_char, empty_char = input("Enter the char to use for denoting the obstacle and the char to denote an empty space the same way: ").split()
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
print("Testing the fill empty char method")
fill_board(board, w, h)
print_board()

def fill_obstacle(board, probability, w):
    for i in range(0, w):
        for char in board[i]:
            char = random.choices([empty_char, tree_char], weights=[1-probability, probability], k=1)[0]

#testing fill obstacle in array method
print("Testing fill obstacle method: ")
fill_obstacle(board, num_trees/w*h, w)
print_board()
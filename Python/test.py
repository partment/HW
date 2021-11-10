# -*- coding: UTF-8 -*-

import numpy as np
from ART import ART

def letter_to_array(letter):
    shape = len(letter), len(letter[0])
    Z = np.zeros(shape, dtype=int)
    for row in range(Z.shape[0]):
        for column in range(Z.shape[1]):
            if letter[row][column] == '#':
                Z[row][column] = 1
    return Z

def print_letter(Z):
    for row in range(Z.shape[0]):
        for col in range(Z.shape[1]):
            if Z[row,col]:
                print( '#', end="" )
            else:
                print( ' ', end="" )
        print( )

if __name__ == '__main__':
    network = ART(n=6*7, m=10, L=1.5, rho=0.5)
    
    A1 = letter_to_array( [' #### ',
                           '#    #',
                           '#    #',
                           '######',
                           '#    #',
                           '#    #',
                           '#    #'] )

    B1 = letter_to_array( ['##### ',
                           '#    #',
                           '#    #',
                           '##### ',
                           '#    #',
                           '#    #',
                           '##### '] )

    A2 = letter_to_array( ['######',
                           '#    #',
                           '#    #',
                           '######',
                           '#    #',
                           '#    #',
                           '#    #'] )
    
    B2 = letter_to_array( [' #### ',
                           '#    #',
                           '#    #',
                           '##### ',
                           '#    #',
                           '#    #',
                           ' #### '] )

    A3 = letter_to_array( [' #### ',
                           '#    #',
                           '#    #',
                           ' #### ',
                           '#    #',
                           '#    #',
                           '#    #'] )

    C1 = letter_to_array( ['######',
                           '#     ',
                           '#     ',
                           '#     ',
                           '#     ',
                           '#     ',
                           '######'] )

    samples = [A1,B1,A2,B2,A3,C1]

    for i in range(len(samples)):
        Z, k = network.learn(samples[i].ravel())
        print_letter(samples[i])
        print(f'is identified with class {k}\n\n')

    NEW_LETTER = letter_to_array( ['######',
                                   '#    #',
                                   '#    #',
                                   '######',
                                   '#    #',
                                   '#    #',
                                   '#    #'] )

    print('the prediction of this input:')
    print_letter(NEW_LETTER)
    print(f'is class {network.predict(NEW_LETTER.ravel())}')
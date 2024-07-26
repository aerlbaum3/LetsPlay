#Adeena Erlbaum
import random #to draw card
      
def main():
    print('The objective of this game is to try to get as \nclose to the number 21 without going over.' 
          '\nWhoever gets closer to the number 21 is the winner.')
    user_selection = input('Do you want to play? ')
        #put the users answer in a while to put input validation and to let the
        #user be able to play as much as they want.
    while user_selection.lower() not in ['y','yes','no','n']:
        print('Invalid selection. Choose either yes, no, y, or n')
        user_selection = input('Do you want to play?')    
    while user_selection.lower() == 'y' or user_selection.lower()== 'yes':
        # calls different methods to complete the action necessary.
        computer_score = computer_logic()
        score = user_score()
        print('Your score is',score)
        results(score,computer_score)
        user_selection = input('Do you want to play again?')
        while user_selection.lower() not in ['y','yes','no','n']:
            print('Invalid selection. Choose either yes, no, y, or n')
            user_selection = input('Do you want to play?  ')
        
    

    #draw card
def draw_card():
    card_value = random.randint(1,13)
    card_suite = random.choice(['Hearts','Spades','Clubs','Diamonds'])
    card_name = card_value
    if card_name == 1:
        card_name = 'Ace'
    elif card_name == 11:
        card_name = 'Jack'
    elif card_name == 12:
        card_name = 'Queen'
    elif card_name == 13:
        card_name = 'King'
    if card_name == 'Jack' or card_name == 'Queen' or card_name == 'King':
        card_value = 10
        
    card_name = str(card_name) + ' of ' + card_suite
    return (card_name,card_value)
    
    
    

#this method calculates user score
def user_score():
    draw_another = 'A'
    score = 0
    while  draw_another.upper() == 'A' and score <= 21:
        card_name, card_value = draw_card()
        score += card_value
        print('Your card was a', card_name)
        print('You now have a score of',score)
        if score <= 21:
            draw_another = input('Do you want to: \nA.Draw another? \nB.Freeze your score?  ')
        while draw_another.upper() not in ['A','B']:
            print('Invalid choice.')
            draw_another = input('Do you want to: \nA.Draw another? \nB.Freeze your score?  ')
            
        
    return(score)
#computers turn happens in this method
def computer_logic():
    score = 0
    while score <= 15:
        card_name, card_value = draw_card()
        score += card_value
    return score
#this method prints out the users score and result of the game.
def results(score,computer_score):
    if score == 21:
        if computer_score == 21:
            print('You tied with the computer! Both getting a score of 21!')
        else:
            print('Yay! You won the computer by getting a score of 21! The Computers score was',computer_score)
    elif score < 21 and computer_score > 21:
        print('Yay! you won the game with a score of',score,'the computer scored a',computer_score,'.')
    elif score > 21 and computer_score < 21:
        print('Sorry you lost the game. The computer won because he got a score of',computer_score,'.')    
    elif score < 21 and computer_score < 21:
        if score > computer_score:
            print('Yay! You won the game with a score of',score,'! The computer scored ',computer_score,'.')
        elif score < computer_score:
            print('Sorry you lost the game, the computer got closer to 21 with a score of',computer_score,'.')
    elif score == computer_score and score > 21:
        print('No winner this round.Your score is',score,'and the computer score is',computer_score,'.')
    elif score > 21 and computer_score > 21:
        if score < computer_score:
            print('You won with score of:',score,'and computer score of:',computer_score,'.')
        elif score > computer_score:
            print('Sorry you lost and computer won with score of',computer_score,'.')

main()
    

        


    
        

    

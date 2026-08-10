import random

HANGMAN_ASCII_ART = """Welcome to the game Hangman
  _    _                    
 | |  | |                                        
 | |  | |                                        
 | |__| | __ _ _ __   __ _ _ __ ___   __ _ _ __  
 |  __  |/ _` | '_ \ / _` | '_ ` _ \ / _` | '_ \ 
 | |  | | (_| | | | | (_| | | | | | | (_| | | | |
 |_|  |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|
                      __/ |      
                     |___/	
                     
"""

MAX_TRIES = random.randint(5, 10)

print(HANGMAN_ASCII_ART, MAX_TRIES)



 
 
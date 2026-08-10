import pygame

pygame.init()

# constant sizes
WINDOW_WIDTH = 990                          # the width of the game window
WINDOW_HEIGHT = 630                         # the height of the game window
SLOT_SIZE = 40                              # the width and height of a slot it the game board
SLOT_BORDER_THICKNESS = 3                   # the thickness of the border between the slots in the game board
BOARD_BORDER_THICKNESS = 24                 # the thickness of the board border
BOARD_BORDER_SHADOWS_THICKNESS = 6          # the thickness of the board border white and dark gray parts
BOARD_BORDER_LIGHT_GRAY_THICKNESS = 12      # the thickness of the board border middle part
BOARD_BORDER_COLOR_DISTANS = 9              # the distance between the starts of the border colors
CONTROL_BOARD_WIDTH = 130                   # the width of the control board
GAP_BETWEEN_SIZE_BUTTONS = 40               # the gap between the "choose a game board" buttons
SIZE_BUTTONS_TOP_Y = 320                    # the vertical position of the "choose a game board" buttons
SIZE_BUTTONS_HEIGHT = 2 * SLOT_SIZE         # the height of the "choose a game board" buttons
SIZE_BUTTONS_WIDTH = 4 * SLOT_SIZE          # the width of the "choose a game board" buttons
CHOOSE_A_GAME_MOOD_HEIGHT = SIZE_BUTTONS_TOP_Y - 100      # the height of the "choose a game board" text

#         R    B    G
WIGHT = (255, 255, 255)         # border highlights
LIGHT_GRAY = (198, 198, 198)    # border middle
DARK_GRAY = (128, 128, 128)     # boarder shadows
BLUE = (0, 0, 255)              # the color of the number 1 on the game board
GREEN = (0, 128, 0)             # the color of the number 2 on the game board
RED = (255, 0, 0)               # the color of the number 3 on the game board
DARK_BLUE = (0, 0, 128)         # the color of the number 4 on the game board
MAROON = (128, 0, 0)            # the color of the number 5 on the game board
TEAL = (0, 128, 128)            # the color of the number 6 on the game board
BLACK = (0, 0, 0)               # the color of the number 7 on the game board
DIM_GRAY = (114, 114, 114)      # the color of the number 8 on the game board
PIGEON_BLUE = (96, 111, 140)    # background color

BG_COLOR = PIGEON_BLUE          # background color

# images
WINDOW = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))      # create a window
COVERED_SLOT = pygame.image.load("images\\slot cover.png").convert_alpha()
COVERED_SLOT = pygame.transform.scale(COVERED_SLOT, (SLOT_SIZE, SLOT_SIZE))
FLAG_SLOT = pygame.image.load("images\\flag.png").convert_alpha()
FLAG_SLOT = pygame.transform.scale(FLAG_SLOT, (SLOT_SIZE, SLOT_SIZE))
WRONG_POS_FLAG_SLOT = pygame.image.load("images\\wrong pos flag.png").convert_alpha()
WRONG_POS_FLAG_SLOT = pygame.transform.scale(WRONG_POS_FLAG_SLOT, (SLOT_SIZE, SLOT_SIZE))
MINE = pygame.image.load("images\\mine.png").convert_alpha()
MINE = pygame.transform.scale(MINE, (SLOT_SIZE, SLOT_SIZE))
RED_MINE = pygame.image.load("images\\red mine.png").convert_alpha()
RED_MINE = pygame.transform.scale(RED_MINE, (SLOT_SIZE, SLOT_SIZE))
CORNER_WIGHT_BOTTEM = pygame.image.load("images\\wight bottem right.png").convert_alpha()
CORNER_WIGHT_BOTTEM = pygame.transform.scale(CORNER_WIGHT_BOTTEM, (7, 7))
CORNER_WIGHT_TOP = pygame.image.load("images\\wight top left.png").convert_alpha()
CORNER_WIGHT_TOP = pygame.transform.scale(CORNER_WIGHT_TOP, (7, 7))
MINESWEEPER_LOGO = pygame.image.load("images\\minesweeper logo.png").convert_alpha()
MINESWEEPER_LOGO_RECT = MINESWEEPER_LOGO.get_rect()
MINESWEEPER_LOGO_RECT.center = (WINDOW_WIDTH // 2, WINDOW_HEIGHT // 2)
BLANK_SIZE_BUTTON = pygame.image.load("images\\blank size button.png").convert_alpha()
BLANK_SIZE_BUTTON = pygame.transform.scale(BLANK_SIZE_BUTTON, (SIZE_BUTTONS_WIDTH, SIZE_BUTTONS_HEIGHT))
SOUND_ON_SLOT = pygame.image.load("images\\sound on slot.png").convert_alpha()
SOUND_ON_SLOT = pygame.transform.scale(SOUND_ON_SLOT, (46, 46))
SOUND_OFF_SLOT = pygame.image.load("images\\sound off slot.png").convert_alpha()
SOUND_OFF_SLOT = pygame.transform.scale(SOUND_OFF_SLOT, (46, 46))
NEW_GAME_SLOT = pygame.image.load("images\\restart slot.png").convert_alpha()
NEW_GAME_SLOT = pygame.transform.scale(NEW_GAME_SLOT, (46, 46))
RED_TRAPEZE = pygame.image.load("images\\red trapeze.png").convert_alpha()
DARK_RED_TRAPEZE = pygame.image.load("images\\dark red trapeze.png").convert_alpha()

# fonts
NUMBER_FONT = pygame.font.SysFont('minesweeper-regular', 24)         # in game board numbers
DIRECTIONS_FONT = pygame.font.SysFont('minesweeper-regular', 40)     # "choose a game board" text
BOARD_SIZE_FONT = pygame.font.SysFont('minesweeper-regular', 20)     # "choose a game board" button text

# display
pygame.display.set_caption("minesweeper")    # set window caption
pygame.display.set_icon(MINE)                # set window icon

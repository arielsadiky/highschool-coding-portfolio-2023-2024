import pygame
import random
import datetime
import board
import constants

pygame.init()


def main():
    # assign variables
    screen = constants.WINDOW
    running = True
    stage = 0
    activate_once = True
    game_in_progress = True
    boards = None
    starting_time = None
    end_time = None
    did_win = False
    sound_on = True

    # sound channels
    Channel1 = pygame.mixer.Channel(1)
    Channel2 = pygame.mixer.Channel(2)
    Channel1.set_volume(10)
    Channel2.set_volume(60)
    Channel1.play(pygame.mixer.Sound("minesweeper background music.mp3"), loops=-1)

    # game lop
    while running:
        event = pygame.event.poll()
        if event.type == pygame.QUIT:
            # close game window
            running = False
        if stage == 0:  # game intro
            # present game intro
            stage = opening_screen(screen)
        elif stage == 1:  # choose game board size
            # present game bord size options
            if activate_once:
                draw_game_board_size_screen(screen)
                activate_once = False
            if event.type == pygame.MOUSEBUTTONDOWN:
                # choose game board size
                stage, boards = choose_game_board_size(sound_on)
                activate_once, game_in_progress, starting_time, end_time = True, True, None, None
        elif stage == 2:  # main game area
            # detect mouse click
            if event.type == pygame.MOUSEBUTTONDOWN:
                # get mouse pos
                mouse_pos = pygame.mouse.get_pos()
                # is in game board area?
                if game_in_progress and (mouse_pos[0] > boards.top_left_x) and (
                        mouse_pos[0] < (boards.top_left_x + (constants.SLOT_SIZE * boards.columns))) and (
                        mouse_pos[1] > boards.top_left_y) and (
                        mouse_pos[1] < (boards.top_left_y + (constants.SLOT_SIZE * boards.rows))):
                    if activate_once:
                        # get game start time
                        starting_time = datetime.datetime.now()
                        activate_once = False
                    # is right click?
                    if event.button == 3:
                        # game board action
                        game_in_progress = boards.game_action(pygame.mouse.get_pos(), True)
                    else:
                        # game board action
                        game_in_progress = boards.game_action(pygame.mouse.get_pos(), False)
                else:
                    # control board action
                    stage = boards.control_board_action(mouse_pos, stage, Channel1)
            # check win
            did_win = boards.check_win()
            # is game still going?
            if not game_in_progress or did_win:
                # get game end time and update stage
                end_time, stage, activate_once = datetime.datetime.now(), 3, True
            # draw game screen
            boards.draw(screen, starting_time, end_time)
        elif stage == 3:  # end of game
            # activate win or lose sound
            if activate_once:
                # play appropriate sound
                if did_win:
                    Channel2.play(pygame.mixer.Sound("success sound.mp3"))
                else:
                    Channel2.play(pygame.mixer.Sound("fail sound.mp3"))
                activate_once = False
            if event.type == pygame.MOUSEBUTTONDOWN:
                # control board actions - "turn sound on and off", "new game"
                stage = boards.control_board_action(pygame.mouse.get_pos(), stage, Channel1)
                # draw game screen
                boards.draw(screen, starting_time, end_time)
                # if control board action was "new game"?
                if stage == 1:
                    activate_once = True
                    sound_on = boards.sound_on
        # refresh screen
        pygame.display.flip()


def opening_screen(screen):
    """
    presents opening screen
    :param screen: the screen the game takes place on
    :type screen: pygame surface
    :return: next stage
    :rtype: int
    """
    # fill background
    pygame.draw.rect(screen, constants.BG_COLOR, (0, 0, constants.WINDOW_WIDTH, constants.WINDOW_HEIGHT))
    # loud minesweeper logo
    screen.blit(constants.MINESWEEPER_LOGO, constants.MINESWEEPER_LOGO_RECT)
    # refresh screen
    pygame.display.flip()
    # opening screen duration
    pygame.time.wait(1500)
    # return next stage (choose game board size)
    return 1


def draw_game_board_size_screen(screen):
    """
    presents game board size option buttons
    :param screen: the screen the game takes place on
    :type screen: pygame surface
    """
    # fill background
    pygame.draw.rect(screen, constants.BG_COLOR, (0, 0, constants.WINDOW_WIDTH, constants.WINDOW_HEIGHT))
    # writ instructions on screen
    directions = constants.DIRECTIONS_FONT.render("CHOOSE A GAME MOOD:", True, constants.BLACK)
    directions_rect = directions.get_rect()
    directions_rect.center = ((constants.WINDOW_WIDTH / 2), constants.CHOOSE_A_GAME_MOOD_HEIGHT)
    screen.blit(directions, directions_rect)
    # calculate left button left side pos
    x = (constants.WINDOW_WIDTH / 2) - (constants.GAP_BETWEEN_SIZE_BUTTONS * 1.5) - (2 * constants.SIZE_BUTTONS_WIDTH)
    for i in range(4):
        # loud bland size button in right place
        screen.blit(constants.BLANK_SIZE_BUTTON, (x, constants.SIZE_BUTTONS_TOP_Y))
        # move x to next button left side pos
        x = x + constants.SIZE_BUTTONS_WIDTH + constants.GAP_BETWEEN_SIZE_BUTTONS
    # calculate left button left side
    x = (constants.WINDOW_WIDTH / 2) - (constants.GAP_BETWEEN_SIZE_BUTTONS * 1.5) - (2 * constants.SIZE_BUTTONS_WIDTH)
    # assign variable
    difficulty = None
    for i in range(4):
        # load correct text
        if i == 0:
            difficulty = constants.BOARD_SIZE_FONT.render("Easy", True, constants.BLACK)
        elif i == 1:
            difficulty = constants.BOARD_SIZE_FONT.render("Medium", True, constants.BLACK)
        elif i == 2:
            difficulty = constants.BOARD_SIZE_FONT.render("Hard", True, constants.BLACK)
        elif i == 3:
            difficulty = constants.BOARD_SIZE_FONT.render("Random", True, constants.BLACK)
        # position text
        difficulty_rect = difficulty.get_rect()
        difficulty_rect.center = (
            x + (constants.SIZE_BUTTONS_WIDTH / 2), constants.SIZE_BUTTONS_TOP_Y + (constants.SIZE_BUTTONS_HEIGHT / 2))
        # present text
        screen.blit(difficulty, difficulty_rect)
        # move x to next button left side pos
        x = x + constants.SIZE_BUTTONS_WIDTH + constants.GAP_BETWEEN_SIZE_BUTTONS
    pygame.display.flip()


def choose_game_board_size(sound_on):
    """
    detects mouse pos and creates appropriate game board
    :return1: if button was pressed then next stage, else current stage
    :rtype1: int
    :return2: new game board
    :rtype2: board
    """
    # assign variables
    stage, boards = 1, 0
    # get mouse position
    mouse_pos = pygame.mouse.get_pos()
    # calculate left button left side pos
    x = (constants.WINDOW_WIDTH / 2) - (constants.GAP_BETWEEN_SIZE_BUTTONS * 1.5) - 2 * (4 * constants.SLOT_SIZE)
    if (mouse_pos[1] > constants.SIZE_BUTTONS_TOP_Y) and (
            mouse_pos[1] < (constants.SIZE_BUTTONS_TOP_Y + constants.SIZE_BUTTONS_HEIGHT)):
        for i in range(4):
            # create correct game board
            if (mouse_pos[0] > x) and (mouse_pos[0] < (x + constants.SIZE_BUTTONS_WIDTH)):
                if i == 0:  # easy
                    boards = board.Board(8, 8, 0.12, sound_on)
                elif i == 1:  # medium
                    boards = board.Board(12, 12, 0.156, sound_on)
                elif i == 2:  # hard
                    boards = board.Board(14, 19, 0.28, sound_on)
                elif i == 3:  # random
                    boards = board.Board(random.randint(6, 14), random.randint(4, 19), random.uniform(0.12, 0.35),
                                         sound_on)
                # update stage
                stage = 2
            # move x to next button left side pos
            x = x + (4 * constants.SLOT_SIZE) + constants.GAP_BETWEEN_SIZE_BUTTONS
    # if new game board was created return next stage (game play) and the new board
    # else return current stage
    return stage, boards


if __name__ == '__main__':
    main()

pygame.quit()

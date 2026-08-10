import random
import constants
import pygame
import datetime


class Board:
    def __init__(self, rows, columns, mine_percentage, sound_on):
        """
        creates new Board Object.
        :param rows: amount of rows in board
        :type rows: int
        :param columns: amount of columns in board
        :type columns: int
        :param mine_percentage: percentage of mines in board
        :type mine_percentage: flot
        :param sound_on: is background music playing
        :type sound_on: boolean
        """
        self.rows = rows
        self.columns = columns
        self.mine_amount = int(rows * columns * mine_percentage)
        self.flag_amount = 0
        self.num_board = self.create_num_board()
        self.status_board = self.create_status_board()
        self.top_left_x, self.top_left_y = self.top_left_coordinates()
        self.sound_on = sound_on

    def create_shuffled_mine_list(self):
        """
        creates a shuffled list of 0 and -1 with the appropriate amount of mines (-1).
        :return: shuffled 0 and -1 list
        :rtype: lst
        """
        # create empty list
        lst = []
        # add mines to list
        for n in range(self.mine_amount):
            lst.append(-1)
        # add empty slots to list
        for n in range((self.rows * self.columns) - self.mine_amount):
            lst.append(0)
        # shuffle list
        random.shuffle(lst)
        # return list
        return lst

    def create_num_board(self):
        """
        creates a matrix that every slot contains
        or -1 or the amount of -1 that sounds it.
        :return: num board
        :rtype: int matrix
        """
        # create shuffled mine list
        lst = self.create_shuffled_mine_list()
        # create empty list
        board = []
        # turn empty list to matrix with the shuffled list values
        for row in range(self.rows):
            board.append([])
            for col in range(self.columns):
                board[-1].append(lst.pop())
        # assign to every non mine slot the number of mines around it.
        for row in range(self.rows):
            for col in range(self.columns):
                if board[row][col] != -1:
                    x = 0
                    i = row - 1
                    j = col - 1
                    while i < row + 2:
                        if i < 0:
                            i = i + 1
                        while j < col + 2:
                            if j < 0:
                                j = j + 1
                            if board[i][j] == -1:
                                x = x + 1
                            if j == (self.columns - 1):
                                j = j + 1
                            j = j + 1
                        if i == (self.rows - 1):
                            i = i + 1
                        i = i + 1
                        j = col - 1
                    board[row][col] = x
        # return new number (value) board
        return board

    def create_status_board(self):
        """
        creates matrix full of 0 (closed slots).
        :return: status board
        :rtype: int matrix
        """
        # create empty list
        board = []
        # turn empty list to matrix with 0
        for row in range(self.rows):
            board.append([])
            for col in range(self.columns):
                board[-1].append(0)
        # return new status board
        return board

    def top_left_coordinates(self):
        """
        calculates top left x and y coordinates.
        :return1: top left x coordinate.
        :rtype1: int
        :return2: top left y coordinate.
        :rtype2: int
        """
        # calculate top left board x value
        top_left_x = int((constants.WINDOW_WIDTH - constants.CONTROL_BOARD_WIDTH - (
                constants.SLOT_SIZE * self.columns) - (3 * constants.BOARD_BORDER_THICKNESS)) / 2) + (
                             2 * constants.BOARD_BORDER_THICKNESS) + constants.CONTROL_BOARD_WIDTH
        # calculate top left board y value
        top_left_y = int((constants.WINDOW_HEIGHT - (constants.SLOT_SIZE * self.rows) - (
                2 * constants.BOARD_BORDER_THICKNESS)) / 2) + constants.BOARD_BORDER_THICKNESS
        # return top left x and y board values
        return top_left_x, top_left_y

    def change_status_board_status(self, row, col, change_to):
        """
        changes status of given slot and
        update flag count accordingly.
        :param row: slot row
        :type row: int
        :param col: slot column
        :type col: int
        :param change_to: new slot status (-2 <= x <= 2)
        :type change_to: int
        """
        # take away flag? subtract a flag from flag count
        if (change_to == 0) or ((self.status_board[row][col] == 1) and (change_to == -1)):
            self.flag_amount = self.flag_amount - 1
        # add flag? add a flag from flag count
        if change_to == 1:
            self.flag_amount = self.flag_amount + 1
        # change slot status
        self.status_board[row][col] = change_to

    def check_win(self):
        """
        checks if all mines are flagged
        and all other slots are open.
        :return: are all mines flagged
                 and all other slots are open?
        :rtype: boolean
        """
        # is flag amount larger ten mine amount?
        if self.flag_amount > self.mine_amount:
            return False
        # Go through all the squares of the game board
        # and check if the flags are above the mines
        # and the other squares are exposed
        for row in range(self.rows):
            for col in range(self.columns):
                if ((self.num_board[row][col] == -1) and (self.status_board[row][col] != 1)) or (
                        (self.num_board[row][col] != -1) and (self.status_board[row][col] == 0)):
                    return False
        return True

    def find_pressed_slot(self, mouse_pos):
        """
        checks if all mines are flagged
        and all other slots are open.
        :param mouse_pos: mouse position
        :type mouse_pos: tuple
        :return: slot position
        :rtype: list
        """
        # simplify top left variables
        x, y = self.top_left_x, self.top_left_y
        # create default slot (slot that dose not exist)
        slot = [-1, -1]
        # Go through all the squares of the game board
        # and check if mouse pos overlaps one of them
        for row in range(self.rows):
            for col in range(self.columns):
                if (mouse_pos[0] > x) and (mouse_pos[0] < (x + constants.SLOT_SIZE)) and (mouse_pos[1] > y) and (
                        mouse_pos[1] < (y + constants.SLOT_SIZE)):
                    # assignee correct slot position
                    slot = [row, col]
                # move x to left of next slot
                x = x + constants.SLOT_SIZE
            # move x to left of game board
            x = self.top_left_x
            # move y to top of next slot
            y = y + constants.SLOT_SIZE
        # return appropriate slot
        return slot

    def game_action(self, mouse_pos, is_right_click):
        """
        changes appropriate slot to correct
        status according to player action.
        :param mouse_pos: mouse position
        :type mouse_pos: tuple
        :param is_right_click: was the mouse click a right click
        :type is_right_click: boolean
        :return: is game still in progres? (player didn't loos)
        :rtype: boolean
        """
        # get pressed slot
        slot = self.find_pressed_slot(mouse_pos)
        # if slot exists
        if slot != [-1, -1]:
            # if flagged and right click
            if (self.status_board[slot[0]][slot[1]] == 1) and is_right_click:
                # unflag slot
                self.change_status_board_status(slot[0], slot[1], 0)
            # if covered slot
            elif self.status_board[slot[0]][slot[1]] == 0:
                if is_right_click:
                    # flag slot
                    self.change_status_board_status(slot[0], slot[1], 1)
                else:
                    # open slot
                    # if slot value is 0 open all surrounding zeros
                    if self.num_board[slot[0]][slot[1]] == 0:
                        self.open_all_neer_zeros(slot)
                    # if slot value is -1 (mine) open all mines and game ended
                    elif self.num_board[slot[0]][slot[1]] == -1:
                        self.change_status_board_status(slot[0], slot[1], -2)
                        self.open_all_mines()
                        return False
                    else:
                        # open slot
                        self.change_status_board_status(slot[0], slot[1], -1)
            # if slot open
            else:
                # open surrounding unflagged slots if
                # around slot same amount of flags and mines
                return self.open_if_possible(slot)
        # no action was made so game still going
        return True

    def open_if_possible(self, slot):
        """
        changes appropriate slot to correct
        status according to player action.
        :param slot: [row number, column number]
        :type slot: list
        :return: is game still in progres? (player didn't loos)
        :rtype: boolean
        """
        # start flag counter
        x = 0
        # if around slot no mines and no flags
        if x == self.num_board[slot[0]][slot[1]]:
            # open slots and return "is game still in progres?"
            return self.open_possible_slots(slot)
        # get top left slot (top left diagonal from given slot)
        # x (i) and y (j)
        i = slot[0] - 1
        j = slot[1] - 1
        # go over all 8 slots that surround given slot
        while i < slot[0] + 2:
            # if i is out of game board bounds
            if i < 0:
                i = i + 1
            # go over row
            while j < slot[1] + 2:
                # if j is out of game board bounds
                if j < 0:
                    j = j + 1
                # if flagged slot add one to flag count
                if self.status_board[i][j] == 1:
                    x = x + 1
                # if j is out of game board bounds
                if j == (self.columns - 1):
                    j = j + 1
                # go to next column
                j = j + 1
            # if i is out of game board bounds
            if i == (self.rows - 1):
                i = i + 1
            # go to next row
            i = i + 1
            # go back to first column
            j = slot[1] - 1
        # if around slot same amount of mines and flags
        if x == self.num_board[slot[0]][slot[1]]:
            # open unflagged slots and return "is game still in progres?"
            return self.open_possible_slots(slot)
        # if no slots were opened game still in progres
        return True

    def open_possible_slots(self, slot):
        """
        open unflagged slots around given slot.
        :param slot: [row number, column number]
        :type slot: list
        :return: is game still in progres? (player didn't loos)
        :rtype: boolean
        """
        # get top left slot (top left diagonal from given slot)
        # x (i) and y (j)
        i = slot[0] - 1
        j = slot[1] - 1
        # go over all 8 slots that surround given slot
        while i < (slot[0] + 2):
            # if i is out of game board bounds
            if i < 0:
                i = i + 1
            # go over row
            while j < (slot[1] + 2):
                # if j is out of game board bounds
                if j < 0:
                    j = j + 1
                # if slot not flagged
                if self.status_board[i][j] != 1:
                    # open slot
                    self.change_status_board_status(i, j, -1)
                    # if opened slot was 0
                    if self.num_board[i][j] == 0:
                        # open all neer zeros
                        self.open_all_neer_zeros([i, j])
                    # if opened slot was mine
                    if self.num_board[i][j] == -1:
                        # open all mines and game ended
                        self.change_status_board_status(i, j, -2)
                        self.open_all_mines()
                        return False
                # if j is out of game board bounds
                if j == (self.columns - 1):
                    j = j + 1
                # go to next column
                j = j + 1
            # if i is out of game board bounds
            if i == (self.rows - 1):
                i = i + 1
            # go to next row
            i = i + 1
            # go back to first column
            j = slot[1] - 1
        # game still going
        return True

    def open_all_neer_zeros(self, slot):
        """
        open all slots surrounding a zero slot.
        :param slot: [row number, column number]
        :type slot: list
        :return: is game still in progres? (player didn't loos)
        :rtype: boolean
        """
        # open slot
        self.change_status_board_status(slot[0], slot[1], -1)
        # get top left slot (top left diagonal from given slot)
        # x (i) and y (j)
        i = slot[0] - 1
        j = slot[1] - 1
        # go over all 8 slots that surround given slot
        while i < (slot[0] + 2):
            # if i is out of game board bounds
            if i < 0:
                i = i + 1
            # go over row
            while j < (slot[1] + 2):
                # if j is out of game board bounds
                if j < 0:
                    j = j + 1
                # if slot is 0 and is already open
                if (self.num_board[i][j] == 0) and (self.status_board[i][j] != -1):
                    # open all slots around that 0
                    self.open_all_neer_zeros([i, j])
                # open slot
                self.change_status_board_status(i, j, -1)
                # if j is out of game board bounds
                if j == (self.columns - 1):
                    j = j + 1
                # go to next column
                j = j + 1
            # if i is out of game board bounds
            if i == (self.rows - 1):
                i = i + 1
            # go to next row
            i = i + 1
            # go back to first column
            j = slot[1] - 1

    def open_all_mines(self):
        """
        opens all mines and marks all wrong flags.
        """
        # gos over all slots in game board
        for row in range(self.rows):
            for col in range(self.columns):
                # if unopened mine
                if (self.num_board[row][col] == -1) and (self.status_board[row][col] == 0):
                    # open slot
                    self.change_status_board_status(row, col, -1)
                # if wrong flag
                if (self.status_board[row][col] == 1) and (self.num_board[row][col] != -1):
                    # mark slot as wrong flag
                    self.change_status_board_status(row, col, 2)

    def control_board_action(self, mouse_pos, stage, channel1):
        """
        controls control board buttons.
        :param mouse_pos: mouse position
        :type mouse_pos: tuple
        :param stage: stage in game loop
        :type stage: int
        :param channel1: channel to play background music
        :type channel1: pygame.mixer.Channel
        :return: stage
        :rtype: int
        """
        # get top left x and y of sound button
        left_x = self.top_left_x - constants.BOARD_BORDER_THICKNESS - constants.CONTROL_BOARD_WIDTH + 12
        top_y = self.top_left_y + (3 * constants.SLOT_SIZE) + 32
        # if mouse click was on sound button
        if (mouse_pos[0] > left_x) and (mouse_pos[0] < (left_x + 46)) and (mouse_pos[1] > top_y) and (
                mouse_pos[1] < (top_y + 46)):
            # if sound on turn off (pause), if off turn on
            self.sound_on = not self.sound_on
            if self.sound_on:
                channel1.unpause()
            else:
                channel1.pause()

        # if mouse click was on "new game" button
        if (mouse_pos[0] > (left_x + 60)) and (mouse_pos[0] < (left_x + 106)) and (mouse_pos[1] > top_y) and (
                mouse_pos[1] < (top_y + 46)):
            # return "choose a game board size" stage
            return 1
        # return current stage
        return stage

    def draw(self, screen, starting_time, finish_time):
        """
        draw game widow
        :param screen: the window screen
        :type screen: pygame.display.mode
        :param starting_time: time of first game move
        :type starting_time: datetime.datetime
        :param finish_time: time of end of game
        :type finish_time: datetime.datetime
        """
        # draw background
        pygame.draw.rect(screen, constants.BG_COLOR, (0, 0, constants.WINDOW_WIDTH, constants.WINDOW_HEIGHT))
        # draw game board slots and slot covers
        self.draw_game_board(screen)
        # draw control board
        self.draw_control_board(screen, starting_time, finish_time)
        # draw boarder around game and control boards
        self.draw_boards_border(screen)

    def draw_game_board(self, screen):
        """
        draw game board
        :param screen: the window screen
        :type screen: pygame.display.mode
        """
        # get top left of game board x and y values
        x, y = self.top_left_x, self.top_left_y
        # assign variable
        num = None
        # go over num and status boards and draw slot value
        for row in range(self.rows):
            for col in range(self.columns):
                # draw slot background
                pygame.draw.rect(screen, constants.LIGHT_GRAY, (x, y, constants.SLOT_SIZE, constants.SLOT_SIZE), 0)
                # draw slot value (mine, 1-8)
                # if mine
                if self.num_board[row][col] == -1:
                    # if slot is pressed mine
                    if self.status_board[row][col] == -2:
                        # draw red mine
                        screen.blit(constants.RED_MINE, (x, y))
                    else:
                        # draw regular mine
                        screen.blit(constants.MINE, (x, y))
                # if 1-8
                # loud correct num in correct color
                elif self.num_board[row][col] == 1:
                    num = constants.NUMBER_FONT.render("1", True, constants.BLUE)
                elif self.num_board[row][col] == 2:
                    num = constants.NUMBER_FONT.render("2", True, constants.GREEN)
                elif self.num_board[row][col] == 3:
                    num = constants.NUMBER_FONT.render("3", True, constants.RED)
                elif self.num_board[row][col] == 4:
                    num = constants.NUMBER_FONT.render("4", True, constants.DARK_BLUE)
                elif self.num_board[row][col] == 5:
                    num = constants.NUMBER_FONT.render("5", True, constants.MAROON)
                elif self.num_board[row][col] == 6:
                    num = constants.NUMBER_FONT.render("6", True, constants.TEAL)
                elif self.num_board[row][col] == 7:
                    num = constants.NUMBER_FONT.render("7", True, constants.BLACK)
                elif self.num_board[row][col] == 8:
                    num = constants.NUMBER_FONT.render("8", True, constants.DIM_GRAY)
                # if 1-8
                if self.num_board[row][col] > 0:
                    # center num
                    num_rect = num.get_rect()
                    num_rect.center = (x + 21, y + 20)
                    # draw num
                    screen.blit(num, num_rect)
                # draw slot outline
                pygame.draw.line(screen, constants.DARK_GRAY, (x, y), (x, y + constants.SLOT_SIZE),
                                 constants.SLOT_BORDER_THICKNESS)
                pygame.draw.line(screen, constants.DARK_GRAY, (x, y), (x + constants.SLOT_SIZE, y),
                                 constants.SLOT_BORDER_THICKNESS)
                # move x to left of next slot
                x = x + constants.SLOT_SIZE
            # move x to left of game board
            x = self.top_left_x
            # move y to top of next slot
            y = y + constants.SLOT_SIZE

        # get top left of game board x and y values
        x, y = self.top_left_x, self.top_left_y
        # go over num and status boards and draw slot cover
        for row in range(self.rows):
            for col in range(self.columns):
                # if slot is covered
                if self.status_board[row][col] == 0:
                    screen.blit(constants.COVERED_SLOT, (x, y))
                # if slot is flagged
                elif self.status_board[row][col] == 1:
                    screen.blit(constants.FLAG_SLOT, (x, y))
                # if slot is wrongly flagged
                elif self.status_board[row][col] == 2:
                    screen.blit(constants.WRONG_POS_FLAG_SLOT, (x, y))
                # move x to left of next slot
                x = x + constants.SLOT_SIZE
            # move x to left of game board
            x = self.top_left_x
            # move y to top of next slot
            y = y + constants.SLOT_SIZE

    def draw_control_board(self, screen, starting_time, finish_time):
        """
        draw control board
        :param screen: the window screen
        :type screen: pygame.display.mode
        :param starting_time: time of first game move
        :type starting_time: datetime.datetime
        :param finish_time: time of end of game
        :type finish_time: datetime.datetime
        """
        # get top left of control board x and y values
        left_x = self.top_left_x - constants.BOARD_BORDER_THICKNESS - constants.CONTROL_BOARD_WIDTH
        top_y = self.top_left_y
        # draw control board background
        pygame.draw.rect(screen, constants.LIGHT_GRAY, (left_x, top_y, constants.CONTROL_BOARD_WIDTH, self.rows * constants.SLOT_SIZE), 0)
        # draw sound button background
        pygame.draw.rect(screen, constants.DARK_GRAY, (left_x + 10, top_y + (3 * constants.SLOT_SIZE) + 30, 50, 50), 0)
        # draw "new game" button background
        pygame.draw.rect(screen, constants.DARK_GRAY, (left_x + 70, top_y + (3 * constants.SLOT_SIZE) + 30, 50, 50), 0)

        # if sound is on
        if self.sound_on:
            # draw "sound on" button
            screen.blit(constants.SOUND_ON_SLOT, (left_x + 12, top_y + (3 * constants.SLOT_SIZE) + 32))
        else:
            # draw "sound off" button
            screen.blit(constants.SOUND_OFF_SLOT, (left_x + 12, top_y + (3 * constants.SLOT_SIZE) + 32))
        # draw "new game" button
        screen.blit(constants.NEW_GAME_SLOT, (left_x + 72, top_y + (3 * constants.SLOT_SIZE) + 32))

        # draw timer
        draw_timer(screen, left_x, top_y, starting_time, finish_time)
        # draw flag count
        self.draw_flag_count(screen, left_x, top_y)

    def draw_flag_count(self, screen, left_x, top_y):
        """
        draw flag count
        :param screen: the window screen
        :type screen: pygame.display.mode
        :param left_x: control board x value
        :type left_x: int
        :param top_y: control board y value
        :type top_y: int
        """
        # draw flag count shadow
        pygame.draw.rect(screen, constants.DARK_GRAY, (
            left_x + 10, top_y + (1.5 * constants.SLOT_SIZE) + 20, constants.CONTROL_BOARD_WIDTH - 20,
            1.5 * constants.SLOT_SIZE), 0)
        # draw flag count background
        pygame.draw.rect(screen, constants.BLACK, (
            left_x + 13, top_y + (1.5 * constants.SLOT_SIZE) + 23, constants.CONTROL_BOARD_WIDTH - 26,
            (1.5 * constants.SLOT_SIZE) - 6), 0)

        # get unflagged mines amount
        flags_left = self.mine_amount - self.flag_amount
        # get first number's (from the left) top left x and y values
        x = left_x + 18
        y = top_y + (1.5 * constants.SLOT_SIZE) + 25
        # draw flag count numbers
        for i in range(3):
            # draw background of number
            screen.blit(constants.DARK_RED_TRAPEZE, (x, y))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 180),
                        (x, y + (1.5 * constants.SLOT_SIZE) - 17))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 90), (x - 2, y))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 90), (x - 2, y + 25))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 270), (x + 20, y))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 270), (x + 20, y + 25))
            screen.blit(constants.DARK_RED_TRAPEZE, (x, y + 24))
            screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 180), (x, y + 19))
            # if first number from the left
            if i == 0:
                if flags_left < (-9):
                    # draw minos sign
                    screen.blit(constants.RED_TRAPEZE, (x, y + 24))
                    screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 180), (x, y + 19))
                elif flags_left < 0:
                    # draw 0
                    draw_timer_num(screen, x, y, 0)
                else:
                    # draw hundreds number
                    draw_timer_num(screen, x, y, (flags_left // 100))
            # if second number from the left
            elif i == 1:
                if (flags_left < 0) and (flags_left > (-10)):
                    # draw minos sign
                    screen.blit(constants.RED_TRAPEZE, (x, y + 24))
                    screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 180), (x, y + 19))
                elif (flags_left < (-9)) and (flags_left > (-100)):
                    # draw tens number
                    draw_timer_num(screen, x, y, ((flags_left * (-1)) // 10) % 10)
                else:
                    # draw tens number
                    draw_timer_num(screen, x, y, (flags_left // 10) % 10)
            # if third number from the left
            elif i == 2:
                # draw ones number
                if (flags_left < 0) and (flags_left > (-10)):
                    draw_timer_num(screen, x, y, flags_left * (-1))
                elif (flags_left < (-9)) and (flags_left > (-100)):
                    draw_timer_num(screen, x, y, (flags_left * (-1)) % 10)
                else:
                    draw_timer_num(screen, x, y, flags_left % 10)
            # get next number's top left x and y values
            x = x + 35

    def draw_boards_border(self, screen):
        """
        draw game board
        :param screen: the window screen
        :type screen: pygame.display.mode
        """
        # get control board left x value
        left_x = self.top_left_x - constants.BOARD_BORDER_THICKNESS - constants.CONTROL_BOARD_WIDTH
        # get game board right x value
        right_x = self.top_left_x + (constants.SLOT_SIZE * self.columns)
        # get boards top y value
        top_y = self.top_left_y
        # get boards bottem y value
        bottem_y = self.top_left_y + (constants.SLOT_SIZE * self.rows)

        # draw left boarder
        pygame.draw.line(screen, constants.WIGHT, (left_x - 22, top_y - 22), (left_x - 22, bottem_y + 22),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)
        pygame.draw.line(screen, constants.LIGHT_GRAY, (left_x - 13, top_y - 22), (left_x - 13, bottem_y + 22),
                         constants.BOARD_BORDER_LIGHT_GRAY_THICKNESS)
        pygame.draw.line(screen, constants.DARK_GRAY, (left_x - 4, top_y - 22), (left_x - 4, bottem_y + 22),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)

        # draw right boarder
        pygame.draw.line(screen, constants.WIGHT, (right_x + 2, top_y - 22), (right_x + 2, bottem_y + 22),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)
        pygame.draw.line(screen, constants.LIGHT_GRAY, (right_x + 11, top_y - 22), (right_x + 11, bottem_y + 22),
                         constants.BOARD_BORDER_LIGHT_GRAY_THICKNESS)
        pygame.draw.line(screen, constants.DARK_GRAY, (right_x + 20, top_y - 22), (right_x + 20, bottem_y + 22),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)

        # draw middle boarder shadow and highlight
        pygame.draw.line(screen, constants.WIGHT, (self.top_left_x - 22, top_y - 22),
                         (self.top_left_x - 22, bottem_y + 22), constants.BOARD_BORDER_SHADOWS_THICKNESS)
        pygame.draw.line(screen, constants.DARK_GRAY, (self.top_left_x - 4, top_y - 22),
                         (self.top_left_x - 4, bottem_y + 22), constants.BOARD_BORDER_SHADOWS_THICKNESS)

        # draw top boarder
        pygame.draw.line(screen, constants.WIGHT, (left_x - 24, top_y - 22), (right_x + 23, top_y - 22),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)
        pygame.draw.line(screen, constants.LIGHT_GRAY, (left_x - 18, top_y - 13), (right_x + 17, top_y - 13),
                         constants.BOARD_BORDER_LIGHT_GRAY_THICKNESS)
        pygame.draw.line(screen, constants.DARK_GRAY, (left_x - 6, top_y - 4), (right_x + 5, top_y - 4),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)

        # draw bottem boarder
        pygame.draw.line(screen, constants.DARK_GRAY, (left_x - 24, bottem_y + 20), (right_x + 23, bottem_y + 20),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)
        pygame.draw.line(screen, constants.LIGHT_GRAY, (left_x - 18, bottem_y + 11), (right_x + 17, bottem_y + 11),
                         constants.BOARD_BORDER_LIGHT_GRAY_THICKNESS)
        pygame.draw.line(screen, constants.WIGHT, (left_x - 6, bottem_y + 2), (right_x + 5, bottem_y + 2),
                         constants.BOARD_BORDER_SHADOWS_THICKNESS)

        # draw middle boarder
        pygame.draw.line(screen, constants.LIGHT_GRAY, (self.top_left_x - 13, top_y - 17),
                         (self.top_left_x - 13, bottem_y + 17), constants.BOARD_BORDER_LIGHT_GRAY_THICKNESS)

        # draw corners
        # top of top right
        screen.blit(constants.CORNER_WIGHT_TOP, (right_x + 17, top_y - 24))
        # bottem of top right
        screen.blit(constants.CORNER_WIGHT_BOTTEM, (right_x - 1, top_y - 6))
        # bottem middle
        screen.blit(constants.CORNER_WIGHT_BOTTEM, (self.top_left_x - 6, bottem_y - 1))
        # top middle
        screen.blit(constants.CORNER_WIGHT_BOTTEM, (self.top_left_x - 25, top_y - 6))
        # bottem of bottem left
        screen.blit(constants.CORNER_WIGHT_TOP, (left_x - 24, bottem_y + 17))
        # top of bottem left
        screen.blit(constants.CORNER_WIGHT_BOTTEM, (left_x - 6, bottem_y - 1))


def draw_timer(screen, left_x, top_y, starting_time, finish_time):
    """
    draw timer
    :param screen: the window screen
    :type screen: pygame.display.mode
    :param left_x: control board x value
    :type left_x: int
    :param top_y: control board y value
    :type top_y: int
    :param starting_time: time of first game move
    :type starting_time: datetime.datetime
    :param finish_time: time of end of game
    :type finish_time: datetime.datetime
    """
    # draw timer shadow
    pygame.draw.rect(screen, constants.DARK_GRAY,
                     (left_x + 10, top_y + 10, constants.CONTROL_BOARD_WIDTH - 20, 1.5 * constants.SLOT_SIZE), 0)
    # draw timer background
    pygame.draw.rect(screen, constants.BLACK,
                     (left_x + 13, top_y + 13, constants.CONTROL_BOARD_WIDTH - 26, (1.5 * constants.SLOT_SIZE) - 6),
                     0)

    # if first move hasn't happened
    if starting_time is None:
        time = 0
    # if game ended
    elif finish_time is not None:
        time = (finish_time - starting_time).seconds
    # if game going
    else:
        time = (datetime.datetime.now() - starting_time).seconds

    # get first number's (from the left) top left x and y values
    x = left_x + 18
    y = top_y + 15
    # draw timer numbers
    for i in range(3):
        # draw background of number
        screen.blit(constants.DARK_RED_TRAPEZE, (x, y))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 180),
                    (x, y + (1.5 * constants.SLOT_SIZE) - 17))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 90), (x - 2, y))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 90), (x - 2, y + 25))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 270), (x + 20, y))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 270), (x + 20, y + 25))
        screen.blit(constants.DARK_RED_TRAPEZE, (x, y + 24))
        screen.blit(pygame.transform.rotate(constants.DARK_RED_TRAPEZE, 180), (x, y + 19))
        # if first number from the left
        if i == 0:
            # draw hundreds number
            draw_timer_num(screen, x, y, (time // 100))
        # if second number from the left
        elif i == 1:
            # draw tens number
            draw_timer_num(screen, x, y, (time // 10) % 10)
        # if third number from the left
        elif i == 2:
            # draw ones number
            draw_timer_num(screen, x, y, time % 10)
        # get next number's top left x and y values
        x = x + 35


def draw_timer_num(screen, x, y, n):
    """
        draw control board
        :param screen: the window screen
        :type screen: pygame.display.mode
        :param x:
        :type x: int
        :param y:
        :type y: int
        :param n: number needed to draw
        :type n: int
        """
    if (n != 1) and (n != 4):
        # draw top of num
        screen.blit(constants.RED_TRAPEZE, (x, y))
    if (n != 1) and (n != 4) and (n != 7):
        # draw bottem of num
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 180), (x, y + (1.5 * constants.SLOT_SIZE) - 17))
    if (n != 5) and (n != 6):
        # draw top right of num
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 270), (x + 20, y))
    if n != 2:
        # draw bottem right of num
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 270), (x + 20, y + 25))
    if (n != 1) and (n != 2) and (n != 3) and (n != 7):
        # draw top left of num
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 90), (x - 2, y))
    if (n == 0) or (n == 2) or (n == 6) or (n == 8):
        # draw bottem left of num
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 90), (x - 2, y + 25))
    if (n != 1) and (n != 7) and (n != 0):
        # draw middle of num
        screen.blit(constants.RED_TRAPEZE, (x, y + 24))
        screen.blit(pygame.transform.rotate(constants.RED_TRAPEZE, 180), (x, y + 19))

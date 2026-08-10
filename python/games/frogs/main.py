import pygame

pygame.init()

# frogs
class Frog:
    def __init__(self, direction, image, pos_h, pos_w):
        self.direction = direction
        self.image = image
        self.rect = image.get_rect()
        self.rect.move_ip(pos_w, pos_h)


# screen
width, height = 800, 400
size = (width, height)
screen = pygame.display.set_mode(size)

# colors
bg_color = (169, 208, 81)
black = (0, 0, 0)

# images and sound
bg_image = pygame.image.load("pond.png").convert_alpha()
green = pygame.image.load("green frog.png").convert_alpha()
green = pygame.transform.scale(green, (60, 60))
red = pygame.image.load("red frog.png").convert_alpha()
red = pygame.transform.scale(red, (60, 60))
blank = pygame.image.load("blank.png").convert_alpha()
blank = pygame.transform.scale(blank, (60, 60))

# variables
frogs = [Frog(1, green, 212, 130), Frog(1, green, 212, 213), Frog(1, green, 212, 296), Frog(0, blank, 212, 379), Frog(-1, red, 212, 462), Frog(-1, red, 212, 545), Frog(-1, red, 212, 628)]


# display
pygame.display.set_caption("the frog game")
pygame.display.flip()


def main():
    running = True
    playing = True
    play_once = True
    while running:
        event = pygame.event.poll()
        if event.type == pygame.QUIT:
            running = False
        if check_win():
            if play_once:
                pygame.mixer.music.load("success-fanfare-trumpets-6185.mp3")
                pygame.mixer.music.play(0)
                play_once = False
                playing = False
        if not can_move():
            if play_once:
                pygame.mixer.music.load("wawawawaaa.mp3")
                pygame.mixer.music.play(0)
                play_once = False
                playing = False
        if playing:
            if event.type == pygame.MOUSEBUTTONDOWN:
                move(pygame.mouse.get_pos())

            # background
            pygame.draw.rect(screen, bg_color, (0, 0, width, height))
            screen.blit(bg_image, (-30, 50))
            for frog in frogs:
                screen.blit(frog.image, frog.rect)
        # refresh screen
        pygame.display.flip()
        pygame.time.wait(10)


# functions
def move(m_pos):
    m_pos = (m_pos[0], m_pos[1], 1, 1)
    for i in range(len(frogs)):
        if frogs[i].rect.colliderect(m_pos):
            can_move1(frogs[i].direction, i)


def can_move1(val, pos):
    print(pos)
    print(pos + val)
    print()
    if is_in_board(pos + val) and (frogs[pos + val].direction == 0):
        frogs[pos + val].rect, frogs[pos].rect = frogs[pos].rect, frogs[pos + val].rect
        frogs[pos + val], frogs[pos] = frogs[pos], frogs[pos + val]
    elif is_in_board(pos + (val*2)) and (frogs[pos + (val*2)].direction == 0):
        frogs[pos + (val*2)].rect, frogs[pos].rect = frogs[pos].rect, frogs[pos + (val*2)].rect
        frogs[pos + (val*2)], frogs[pos] = frogs[pos], frogs[pos + (val*2)]


def is_in_board(pos):
    return (pos > -1) and (pos < len(frogs))


def can_move():
    pos_0 = 0
    while frogs[pos_0].direction != 0:
        pos_0 = pos_0+1
    c_move = False
    for i in range(1, 3):
        if is_in_board(pos_0-i) and frogs[pos_0-i].direction == 1:
            c_move = True
        if is_in_board(pos_0+i) and frogs[pos_0+i].direction == -1:
            c_move = True
    return c_move


def check_win():
    win = True
    for i in range(3):
        if frogs[i].direction != -1:
            win = False
    for i in range(6, 3, -1):
        if frogs[i].direction != 1:
            win = False
    return win


if __name__ == '__main__':
    main()

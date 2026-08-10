import pygame
import random

# size
width = int(input("enter width of the window you want: "))
height = int(input("enter height of the window you want: "))
size = (width, height)
dice_size = int(input("enter dice size you want: "))
dice_dots_radius = dice_size / 9


# colors
c1 = (56, 102, 65)
c2 = (106, 153, 78)
c3 = (167, 201, 87)
c4 = (242, 232, 207)
c5 = (188, 71, 73)

background_c = c4
dice_border_c = c2
dice_c = c3
dice_dots_c = c1


# functions
def draw_nums_on_dice(dice_middle_x, dice_middle_y, dice_right, dice_left, dice_top, dice_bottom):
    num = random.randint(1, 6)
    if num % 2 != 0:
        pygame.draw.circle(screen, dice_dots_c, (dice_middle_x, dice_middle_y), dice_dots_radius, 0)
    if num > 1:
        pygame.draw.circle(screen, dice_dots_c, (dice_right, dice_top), dice_dots_radius, 0)
        pygame.draw.circle(screen, dice_dots_c, (dice_left, dice_bottom), dice_dots_radius, 0)
    if num > 3:
        pygame.draw.circle(screen, dice_dots_c, (dice_left, dice_top), dice_dots_radius, 0)
        pygame.draw.circle(screen, dice_dots_c, (dice_right, dice_bottom), dice_dots_radius, 0)
    if num == 6:
        pygame.draw.circle(screen, dice_dots_c, (dice_middle_x, dice_top), dice_dots_radius, 0)
        pygame.draw.circle(screen, dice_dots_c, (dice_middle_x, dice_bottom), dice_dots_radius, 0)
    pygame.display.flip()


def draw_dice_bg(dice_drawing):
    pygame.draw.rect(screen, dice_c, dice_drawing, 0)
    pygame.draw.rect(screen, dice_border_c, dice_drawing, 2)


def roll_dice(last_middle_x: int, last_middle_y: int) -> tuple:
    dice_middle_x = random.randint(dice_size // 2 + 5, width - dice_size // 2 - 5)
    while abs(last_middle_x-dice_middle_x) < dice_size+4:
        dice_middle_x = random.randint(dice_size // 2 + 5, width - dice_size // 2 - 5)
    dice_middle_y = random.randint(dice_size // 2 + 5, height - dice_size // 2 - 5)
    while abs(last_middle_y-dice_middle_y) < dice_size+4:
        dice_middle_y = random.randint(dice_size // 2 + 5, height - dice_size // 2 - 5)
    dice_drawing = (dice_middle_x - dice_size / 2, dice_middle_y - dice_size / 2, dice_size, dice_size)
    dice_right = dice_middle_x - dice_size // 4
    dice_left = dice_middle_x + dice_size // 4
    dice_top = dice_middle_y - dice_size // 4
    dice_bottom = dice_middle_y + dice_size // 4
    for i in range(0, 15):
        draw_dice_bg(dice_drawing)
        draw_nums_on_dice(dice_middle_x, dice_middle_y, dice_right, dice_left, dice_top, dice_bottom)
        pygame.time.wait(25)
    return dice_middle_x, dice_middle_y


# display
screen = pygame.display.set_mode(size)
pygame.display.set_caption("my dice")
screen.fill(background_c)
pygame.display.flip()

running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    screen.fill(background_c)
    if event.type == pygame.MOUSEBUTTONUP:
        x, y = roll_dice(0, 0)
        roll_dice(x, y)



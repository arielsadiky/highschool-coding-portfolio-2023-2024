import pygame

# screen
width, height = 850, 550
size = (width, height)
screen = pygame.display.set_mode(size)
square_size = 40

# squares
red = pygame.image.load("red squer.png").convert()
red = pygame.transform.scale(red, (square_size, square_size))
red_rect = red.get_rect()
orange = pygame.image.load("oreng squer.png").convert()
orange = pygame.transform.scale(orange, (square_size, square_size))
orange_rect = orange.get_rect()
yellow = pygame.image.load("yellow squer.png").convert()
yellow = pygame.transform.scale(yellow, (square_size, square_size))
yellow_rect = yellow.get_rect()
green = pygame.image.load("green squer.png").convert()
green = pygame.transform.scale(green, (square_size, square_size))
green_rect = green.get_rect()
light_blue = pygame.image.load("light blue squer.png").convert()
light_blue = pygame.transform.scale(light_blue, (square_size, square_size))
light_blue_rect = light_blue.get_rect()
blue = pygame.image.load("blue squer.png").convert()
blue = pygame.transform.scale(blue, (square_size, square_size))
blue_rect = blue.get_rect()
purple = pygame.image.load("purple squer.png").convert()
purple = pygame.transform.scale(purple, (square_size, square_size))
purple_rect = purple.get_rect()


# dx dy
red_dx, red_dy = 2, 2
orange_dx, orange_dy = 2, 4
yellow_dx, yellow_dy = 4, 2
green_dx, green_dy = 2, 6
light_blue_dx, light_blue_dy = 6, 2
blue_dx, blue_dy = 2, 8
purple_dx, purple_dy = 8, 2

# direction, True=right  False=left
red_direction = True
orange_direction = False
yellow_direction = True
green_direction = False
light_direction = True
blue_direction = False
purple_direction = True


# functions
def move_square(square, square_rect, dx, dy, direction):
    if square_rect.x > width-square_size or square_rect.x < 0 or square_rect.y > height-square_size or square_rect.y < 0:
        if direction:
            temp = dy
            dy = dx
            dx = -1*temp
        else:
            temp = dx
            dx = dy
            dy = -1*temp
    square_rect = square_rect.move(dx, dy)
    screen.blit(square, square_rect)
    return square_rect, dx, dy


def switch_colors(red_, orange_, yellow_, green_, light_blue_, blue_, purple_):
    return orange_, yellow_, green_, light_blue_, blue_, purple_, red_


# display
pygame.display.set_caption("my dice")
screen.fill((0, 0, 0))
pygame.display.flip()
sleep = 40

running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    if event.type == pygame.MOUSEBUTTONUP:
        (red, orange, yellow, green, light_blue, blue, purple) = switch_colors(red, orange, yellow, green, light_blue, blue, purple)
    if event.type == pygame.KEYDOWN:
        if event.key == pygame.K_DOWN:
            sleep = sleep + 5
        if event.key == pygame.K_UP:
            if sleep > 5:
                sleep = sleep - 5
    screen.fill((0, 0, 0))
    red_rect, red_dx, red_dy = move_square(red, red_rect, red_dx, red_dy, red_direction)
    orange_rect, orange_dx, orange_dy = move_square(orange, orange_rect, orange_dx, orange_dy, orange_direction)
    yellow_rect, yellow_dx, yellow_dy = move_square(yellow, yellow_rect, yellow_dx, yellow_dy, yellow_direction)
    green_rect, green_dx, green_dy = move_square(green, green_rect, green_dx, green_dy, green_direction)
    light_blue_rect, light_blue_dx, light_blue_dy = move_square(light_blue, light_blue_rect, light_blue_dx, light_blue_dy, light_blue)
    blue_rect, blue_dx, blue_dy = move_square(blue, blue_rect, blue_dx, blue_dy, blue_direction)
    purple_rect, purple_dx, purple_dy = move_square(purple, purple_rect, purple_dx, purple_dy, purple_direction)
    pygame.display.flip()
    pygame.time.wait(sleep)

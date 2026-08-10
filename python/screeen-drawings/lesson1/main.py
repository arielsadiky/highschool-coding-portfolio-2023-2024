import pygame

width = int(input("enter width of the window you want: "))
height = int(input("enter height of the window you want: "))
size = (width, height)

red = int(input("enter the red value of the background (0-255): "))
green = int(input("enter the green value of the background (0-255): "))
blue = int(input("enter the blue value of the background (0-255): "))
background = (red, green, blue)

red = int(input("enter the red value of the line color (0-255): "))
green = int(input("enter the green value of the line color (0-255): "))
blue = int(input("enter the blue value of the line color (0-255): "))
line_color = (red, green, blue)

point1_x = int(input("enter point1 x value (0-%d): " % width))
point1_y = int(input("enter point1 y value (0-%d): " % height))
point1 = (point1_x, point1_y)

point2_x = int(input("enter point2 x value (0-%d): " % width))
point2_y = int(input("enter point2 y value (0-%d): " % height))
point2 = (point2_x, point2_y)


screen = pygame.display.set_mode(size)
screen.fill(background)
pygame.draw.line(screen, line_color, point1, point2)

running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    pygame.display.flip()

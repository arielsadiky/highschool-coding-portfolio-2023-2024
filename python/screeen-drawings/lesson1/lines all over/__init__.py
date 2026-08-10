import pygame

width = int(input("enter width of the window you want: "))
height = int(input("enter height of the window you want: "))
size = (width, height)

white = (255, 255, 255)

red = int(input("enter the red value of the first color (0-255): "))
green = int(input("enter the green value of the first color (0-255): "))
blue = int(input("enter the blue value of the first color (0-255): "))
first_color = (red, green, blue)

red = int(input("enter the red value of the second color (0-255): "))
green = int(input("enter the green value of the second color (0-255): "))
blue = int(input("enter the blue value of the second color (0-255): "))
second_color = (red, green, blue)

red = int(input("enter the red value of the third color (0-255): "))
green = int(input("enter the green value of the third color (0-255): "))
blue = int(input("enter the blue value of the third color (0-255): "))
third_color = (red, green, blue)

top_left = (0, 0)
top_right = (width, 0)
bottom_left = (0, height)
bottom_right = (width, height)
top_middel = (width/2, 0)
bottom_middel = (width/2, height)
middel = (width/2, height/2)
left_middel = (0, height/2)
right_middel = (width, height/2)

screen = pygame.display.set_mode(size)
screen.fill(white)
pygame.draw.line(screen, first_color, top_left, bottom_right)
pygame.draw.line(screen, first_color, top_right, bottom_left)
pygame.draw.line(screen, second_color, top_middel, bottom_middel)
pygame.draw.line(screen, second_color, left_middel, right_middel)
pygame.draw.line(screen, third_color, top_middel, left_middel)
pygame.draw.line(screen, third_color, left_middel, bottom_middel)
pygame.draw.line(screen, third_color, bottom_middel, right_middel)
pygame.draw.line(screen, third_color, right_middel, top_middel)

running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    pygame.display.flip()

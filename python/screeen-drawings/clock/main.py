import pygame
import datetime
import math

# size
width = int(input("enter width of the window you want: "))
height = int(input("enter height of the window you want: "))
size = (width, height)
radius = int(input("enter radius of the clock you want: "))
center_x = width//2
center_y = height//2
hour_radius = radius*5//9
minute_radius = radius*7//9
second_radius = radius*7//8
_1x = center_x + (math.cos(math.pi/3) * radius)
_1y = center_y - (math.sin(math.pi/3) * radius)
_2x = center_x + (math.cos(math.pi/6) * radius)
_2y = center_y - (math.sin(math.pi/6) * radius)
_3x = center_x + radius
_3y = center_y
_4x = center_x + (math.cos(math.pi/6) * radius)
_4y = center_y + (math.sin(math.pi/6) * radius)
_5x = center_x + (math.cos(math.pi/3) * radius)
_5y = center_y + (math.sin(math.pi/3) * radius)
_6x = center_x
_6y = center_y + radius
_7x = center_x - (math.cos(math.pi/3) * radius)
_7y = center_y + (math.sin(math.pi/3) * radius)
_8x = center_x - (math.cos(math.pi/6) * radius)
_8y = center_y + (math.sin(math.pi/6) * radius)
_9x = center_x - radius
_9y = center_y
_10x = center_x - (math.cos(math.pi/6) * radius)
_10y = center_y - (math.sin(math.pi/6) * radius)
_11x = center_x - (math.cos(math.pi/3) * radius)
_11y = center_y - (math.sin(math.pi/3) * radius)
_12x = center_x
_12y = center_y - radius
border_radius = radius*8/30
hour_mark_length = radius - radius*4/38
minute_mark_length = radius - radius*2/38

# colors
c1 = (51, 0, 112)
c2 = (92, 0, 184)
c3 = (135, 0, 255)
c4 = (165, 75, 255)
c5 = (199, 137, 255)
c6 = (200, 120, 180)
c7 = (237, 210, 254)


bg_color = c5
outline_color = c1
middel_color = c1
clock_bg_color = c7
hour_color = c2
minute_color = c3
second_color = c4
nums_color = c6

# display
screen = pygame.display.set_mode(size)
pygame.display.set_caption("my DLR clock")


running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    # display
    screen.fill(bg_color)

    pygame.draw.circle(screen, clock_bg_color, (center_x, center_y), radius, 0)

    pygame.draw.line(screen, nums_color, (_1x, _1y), (center_x + (math.cos(math.pi/3) * hour_mark_length), center_y - (math.sin(math.pi/3) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_2x, _2y), (center_x + (math.cos(math.pi/6) * hour_mark_length), center_y - (math.sin(math.pi/6) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_3x, _3y), (_3x - radius*4/38, _3y), 4)
    pygame.draw.line(screen, nums_color, (_4x, _4y), (center_x + (math.cos(math.pi/6) * hour_mark_length), center_y + (math.sin(math.pi/6) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_5x, _5y), (center_x + (math.cos(math.pi/3) * hour_mark_length), center_y + (math.sin(math.pi/3) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_6x, _6y), (_6x, _6y - radius*4/38), 4)
    pygame.draw.line(screen, nums_color, (_7x, _7y), (center_x - (math.cos(math.pi/3) * hour_mark_length), center_y + (math.sin(math.pi/3) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_8x, _8y), (center_x - (math.cos(math.pi/6) * hour_mark_length), center_y + (math.sin(math.pi/6) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_9x, _9y), (_9x + radius*4/38, _9y), 4)
    pygame.draw.line(screen, nums_color, (_10x, _10y), (center_x - (math.cos(math.pi/6) * hour_mark_length), center_y - (math.sin(math.pi/6) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_11x, _11y), (center_x - (math.cos(math.pi/3) * hour_mark_length), center_y - (math.sin(math.pi/3) * hour_mark_length)), 4)
    pygame.draw.line(screen, nums_color, (_12x, _12y), (_12x, _12y + radius*4/38), 4)

    for num in range(90, 0, -6):
        pygame.draw.line(screen, nums_color, (center_x + (math.cos(math.pi*num/180) * minute_mark_length), center_y - (math.sin(math.pi*num/180) * minute_mark_length)), (center_x + (math.cos(math.pi*num/180) * radius), center_y - (math.sin(math.pi*num/180) * radius)), 4)
    for num in range(90, 0, -6):
        pygame.draw.line(screen, nums_color, (center_x + (math.cos(math.pi*num/180) * minute_mark_length), center_y + (math.sin(math.pi*num/180) * minute_mark_length)), (center_x + (math.cos(math.pi*num/180) * radius), center_y + (math.sin(math.pi*num/180) * radius)), 4)
    for num in range(90, 0, -6):
        pygame.draw.line(screen, nums_color, (center_x - (math.cos(math.pi*num/180) * minute_mark_length), center_y + (math.sin(math.pi*num/180) * minute_mark_length)), (center_x - (math.cos(math.pi*num/180) * radius), center_y + (math.sin(math.pi*num/180) * radius)), 4)
    for num in range(90, 0, -6):
        pygame.draw.line(screen, nums_color, (center_x - (math.cos(math.pi*num/180) * minute_mark_length), center_y - (math.sin(math.pi*num/180) * minute_mark_length)), (center_x - (math.cos(math.pi*num/180) * radius), center_y - (math.sin(math.pi*num/180) * radius)), 4)

    pygame.draw.circle(screen, outline_color, (center_x, center_y), radius, 4)

    pygame.draw.line(screen, outline_color, (_1x - (math.sin(math.pi/3) * border_radius), _1y - (math.cos(math.pi/3) * border_radius)), (_1x + (math.sin(math.pi/3) * border_radius), _1y + (math.cos(math.pi/3) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_2x - (math.sin(math.pi/6) * border_radius), _2y - (math.cos(math.pi/6) * border_radius)), (_2x + (math.sin(math.pi/6) * border_radius), _2y + (math.cos(math.pi/6) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_3x, _3y - border_radius), (_3x, _3y + border_radius), 4)
    pygame.draw.line(screen, outline_color, (_4x - (math.sin(math.pi/6) * border_radius), _4y + (math.cos(math.pi/6) * border_radius)), (_4x + (math.sin(math.pi/6) * border_radius), _4y - (math.cos(math.pi/6) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_5x - (math.sin(math.pi/3) * border_radius), _5y + (math.cos(math.pi/3) * border_radius)), (_5x + (math.sin(math.pi/3) * border_radius), _5y - (math.cos(math.pi/3) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_6x - border_radius, _6y), (_6x + border_radius, _6y), 4)
    pygame.draw.line(screen, outline_color, (_7x - (math.sin(math.pi/3) * border_radius), _7y - (math.cos(math.pi/3) * border_radius)), (_7x + (math.sin(math.pi/3) * border_radius), _7y + (math.cos(math.pi/3) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_8x - (math.sin(math.pi/6) * border_radius), _8y - (math.cos(math.pi/6) * border_radius)), (_8x + (math.sin(math.pi/6) * border_radius), _8y + (math.cos(math.pi/6) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_9x, _9y - border_radius), (_9x, _9y + border_radius), 4)
    pygame.draw.line(screen, outline_color, (_10x - (math.sin(math.pi/6) * border_radius), _10y + (math.cos(math.pi/6) * border_radius)), (_10x + (math.sin(math.pi/6) * border_radius), _10y - (math.cos(math.pi/6) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_11x - (math.sin(math.pi/3) * border_radius), _11y + (math.cos(math.pi/3) * border_radius)), (_11x + (math.sin(math.pi/3) * border_radius), _11y - (math.cos(math.pi/3) * border_radius)), 4)
    pygame.draw.line(screen, outline_color, (_12x - border_radius, _12y), (_12x + border_radius, _12y), 4)

    now = datetime.datetime.now()
    hour = now.hour % 12
    minute = now.minute
    second = now.second

    pygame.draw.line(screen, second_color, (center_x, center_y), (center_x + (second_radius*math.sin(2*math.pi*(second/60))), center_y - (second_radius*math.cos(2*math.pi*(second/60)))), 4)
    pygame.draw.line(screen, minute_color, (center_x, center_y), (center_x + (minute_radius*math.sin(2*math.pi*(minute/60))), center_y - (minute_radius*math.cos(2*math.pi*(minute/60)))), 4)
    pygame.draw.line(screen, hour_color, (center_x, center_y), (center_x + (hour_radius*math.sin(2*math.pi*(hour/12))), center_y - (hour_radius*math.cos(2*math.pi*(hour/12)))), 4)
    pygame.draw.circle(screen, outline_color, (center_x, center_y), radius//40, 0)

    pygame.display.flip()

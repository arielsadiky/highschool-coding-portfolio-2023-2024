import pygame
import random
import datetime

pygame.init()


# functions
def water_drop_generator(drop):
    drop_size = random.randint(10, 16)
    drop = pygame.transform.scale(drop, (drop_size, 1.5*drop_size))
    drop_rect = drop.get_rect()
    drop_rect = drop_rect.move(random.randint(0, width-drop_size), 0)
    return drop, drop_rect


def func_timer(start_count_, sec_now_, red_flash_, black_flash_, red_black_flash_, timer_rect_, timer_font_, black_, red_):
    if sec_now_ > start_count_:
        if (60+start_count-sec_now) <= 3:
            if red_flash_ > 0 and red_black_flash_:
                timer_ = timer_font_.render('0:0%d' % (60+start_count-sec_now), True, red_)
                red_flash_ = red_flash_-1
            elif black_flash_ > 0 and not red_black_flash_:
                timer_ = timer_font_.render('0:0%d' % (60+start_count-sec_now), True, black_)
                black_flash_ = black_flash_-1
            if red_flash_ == 0:
                red_flash_ = 15
                red_black_flash_ = False
            elif black_flash_ == 0:
                black_flash_ = 15
                red_black_flash_ = True
        elif (60+start_count-sec_now) < 10:
            timer_ = timer_font_.render('0:0%d' % (60+start_count-sec_now), True, black_)
        else:
            timer_ = timer_font_.render('0:%d' % (60+start_count-sec_now), True, black_)
    elif sec_now_ <= start_count_:
        if (start_count_-sec_now_) <= 3:
            if red_flash_ > 0 and red_black_flash_:
                timer_ = timer_font_.render('0:0%d' % (start_count-sec_now), True, red_)
                red_flash_ = red_flash_-1
            elif black_flash_ > 0 and not red_black_flash_:
                timer_ = timer_font_.render('0:0%d' % (start_count-sec_now), True, black_)
                black_flash_ = black_flash_-1
            if red_flash_ == 0:
                red_flash_ = 15
                red_black_flash_ = False
            elif black_flash_ == 0:
                black_flash_ = 15
                red_black_flash_ = True
        elif (start_count_-sec_now_) < 10:
            timer_ = timer_font_.render('0:0%d' % (start_count_-sec_now_), True, black_)
        else:
            timer_ = timer_font_.render('0:%d' % (start_count_-sec_now_), True, black_)
    screen.blit(timer_, timer_rect_)
    return red_flash_, black_flash_, red_black_flash_


def func_pre_count(start_count_, pre_count_, pre_count_rect_, stage_, pre_count_font_, count_):
    sec_now_ = datetime.datetime.now().second
    if abs(start_count_-sec_now_) > 0:
        start_count_ = start_count_+1
        if pre_count_ > 0:
            count_ = pre_count_font_.render('%d' % pre_count_, True, black)
            pygame.mixer.music.load("beep1-3.mp3")
            pygame.mixer.music.play(0)
        elif pre_count_ == 0:
            pre_count_rect_ = pre_count_rect_.move(-30, 0)
            count_ = pre_count_font_.render('go!', True, black)
            pygame.mixer.music.load("beep-go.mp3")
            pygame.mixer.music.play(0)
        else:
            stage_ = stage+1
            start_count_ = start_count_-1
            pygame.mixer.music.load("water-droplet-6-165636.mp3")
        pre_count_ = pre_count_-1
    return start_count_, pre_count_, pre_count_rect_, stage_, count_


def func_display1(bg_image_, border_color_, bucket_, bucket_rect_, timer_, timer_rect_, count_, pre_count_rect_):
    # background
    screen.blit(bg_image_, (0, 0))
    # border
    pygame.draw.rect(screen, border_color_, (0, 0, width, height), 5)
    # bucket
    screen.blit(bucket_, bucket_rect_)
    # timer
    screen.blit(timer_, timer_rect_)
    # pre count
    screen.blit(count_, pre_count_rect_)


# screen
width, height = 560, 633
size = (width, height)
screen = pygame.display.set_mode(size)
dx = 0


# images
bg_image = pygame.image.load("background .png").convert()
bucket = pygame.image.load("—Pngtree—bucket vector icon in flat_6093293 (1).png").convert_alpha()
bucket = pygame.transform.scale(bucket, (100, 100))
bucket_rect = bucket.get_rect()
bucket_rect.move_ip(width//2-40, 500)
water_drop = pygame.image.load("water-drop-icon.png").convert_alpha()
pygame.display.set_icon(water_drop)
water_drop1, rect1 = water_drop_generator(water_drop)
dy1 = 2
water_drop2, rect2 = water_drop_generator(water_drop)
dy2 = 3
water_drop3, rect3 = water_drop_generator(water_drop)
dy3 = 4
water_drop4, rect4 = water_drop_generator(water_drop)
dy4 = 2
water_drop5, rect5 = water_drop_generator(water_drop)
dy5 = 3
water_drop6, rect6 = water_drop_generator(water_drop)
dy6 = 4
test_tube = pygame.image.load("test tube.png").convert_alpha()
test_tube = pygame.transform.scale(test_tube, (40, 134))
test_tube_rect = test_tube.get_rect()
test_tube_rect.center = (width-30, 150)


# colors
border_color = (155, 195, 209)
black = (0, 0, 0)
red = (255, 0, 0)

# timer
timer_font = pygame.font.SysFont('comicsansms', 30)
start_count = datetime.datetime.now().second
timer = timer_font.render('1:00', True, black)
timer_rect = timer.get_rect()
timer_rect.move_ip(width-80, 0)

# pre count
pre_count = 3
pre_count_font = pygame.font.SysFont('comicsansms', 80)
count = pre_count_font.render('%d' % pre_count, True, black)
pre_count_rect = count.get_rect()
pre_count_rect.move_ip(width//2-10, height//2-70)

# end
congratulations_font = pygame.font.SysFont('comicsansms', 44)
congratulations = congratulations_font.render('congratulations!', True, black)
congratulations_rect = congratulations.get_rect()
congratulations_rect.center = (width//2, height//2-35)
you_got_100_points_font = pygame.font.SysFont('comicsansms', 30)
you_got_100_points = you_got_100_points_font.render('you got 100 points', True, black)
you_got_100_points_rect = you_got_100_points.get_rect()
you_got_100_points_rect.center = (width//2, height//2+8)
with_sec_left_font = pygame.font.SysFont('comicsansms', 24)
with_sec_left = with_sec_left_font.render('with 0 seconds left', True, black)
with_sec_left_rect = with_sec_left.get_rect()
failed = congratulations_font.render('you failed!', True, black)
failed_rect = failed.get_rect()
failed_rect.center = (width//2, height//2-35)
maby_next_time = you_got_100_points_font.render('maby next time', True, black)
maby_next_time_rect = maby_next_time.get_rect()
maby_next_time_rect.center = (width//2, height//2+8)
you_got_points = with_sec_left_font.render('you_got_points', True, black)
you_got_points_rect = you_got_points.get_rect()


# display
pygame.display.set_caption("catch the drops")
pygame.display.flip()

play_once = True
red_flash = 15
black_flash = 15
points = 0
red_black_flash = True
stage = 1
running = True
while running:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        running = False
    if stage == 1:
        # set pre count settings
        start_count, pre_count, pre_count_rect, stage, count = func_pre_count(start_count, pre_count, pre_count_rect, stage, pre_count_font, count)
        # display pre count
        func_display1(bg_image, border_color, bucket, bucket_rect, timer, timer_rect, count, pre_count_rect)
    elif stage == 2:
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                dx = -4
            elif event.key == pygame.K_RIGHT:
                dx = 4
        elif event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                dx = 0
        if bucket_rect.x+dx <= 10 or bucket_rect.x+dx >= width-110:
            dx = 0
        if bucket_rect.colliderect(rect1) or rect1.bottom >= 550:
            if bucket_rect.colliderect(rect1):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop1, rect1 = water_drop_generator(water_drop)
        if bucket_rect.colliderect(rect2) or rect2.bottom >= 550:
            if bucket_rect.colliderect(rect2):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop2, rect2 = water_drop_generator(water_drop)
        if bucket_rect.colliderect(rect3) or rect3.bottom >= 550:
            if bucket_rect.colliderect(rect3):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop3, rect3 = water_drop_generator(water_drop)
        if bucket_rect.colliderect(rect4) or rect4.bottom >= 550:
            if bucket_rect.colliderect(rect4):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop4, rect4 = water_drop_generator(water_drop)
        if bucket_rect.colliderect(rect5) or rect5.bottom >= 550:
            if bucket_rect.colliderect(rect5):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop5, rect5 = water_drop_generator(water_drop)
        if bucket_rect.colliderect(rect6) or rect6.bottom >= 550:
            if bucket_rect.colliderect(rect6):
                points = points+1
                pygame.mixer.music.play(0)
            water_drop6, rect6 = water_drop_generator(water_drop)

        # background
        screen.blit(bg_image, (0, 0))
        # bucket
        bucket_rect = bucket_rect.move(dx, 0)
        screen.blit(bucket, bucket_rect)
        # drops
        rect1 = rect1.move(0, dy1)
        screen.blit(water_drop1, rect1)
        rect2 = rect2.move(0, dy2)
        screen.blit(water_drop2, rect2)
        rect3 = rect3.move(0, dy3)
        screen.blit(water_drop3, rect3)
        rect4 = rect4.move(0, dy4)
        screen.blit(water_drop4, rect4)
        rect5 = rect5.move(0, dy5)
        screen.blit(water_drop5, rect5)
        rect6 = rect6.move(0, dy6)
        screen.blit(water_drop6, rect6)
        # timer
        sec_now = datetime.datetime.now().second
        red_flash, black_flash, red_black_flash = func_timer(start_count, sec_now, red_flash, black_flash, red_black_flash, timer_rect, timer_font, black, red)
        # border
        if red_black_flash:
            pygame.draw.rect(screen, border_color, (0, 0, width, height), 5)
        elif not red_black_flash:
            pygame.draw.rect(screen, red, (0, 0, width, height), 5)
        # test tube
        if points >= 10:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 203), (width-30, 195), 12)
            pygame.draw.line(screen, (66, 165, 245), (width-30, 207), (width-30, 203), 8)
        if points >= 100:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 105), (width-30, 195), 12)
        elif points >= 90:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 115), (width-30, 195), 12)
        elif points >= 80:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 125), (width-30, 195), 12)
        elif points >= 70:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 135), (width-30, 195), 12)
        elif points >= 60:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 145), (width-30, 195), 12)
        elif points >= 50:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 155), (width-30, 195), 12)
        elif points >= 40:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 165), (width-30, 195), 12)
        elif points >= 30:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 175), (width-30, 195), 12)
        elif points >= 20:
            pygame.draw.line(screen, (66, 165, 245), (width-30, 185), (width-30, 195), 12)
        pygame.draw.line(screen, black, (width-35, 105), (width-24, 105), 2)
        pygame.draw.line(screen, black, (width-35, 115), (width-24, 115), 2)
        pygame.draw.line(screen, black, (width-35, 125), (width-24, 125), 2)
        pygame.draw.line(screen, black, (width-35, 135), (width-24, 135), 2)
        pygame.draw.line(screen, black, (width-35, 145), (width-24, 145), 2)
        pygame.draw.line(screen, black, (width-35, 155), (width-24, 155), 2)
        pygame.draw.line(screen, black, (width-35, 165), (width-24, 165), 2)
        pygame.draw.line(screen, black, (width-35, 175), (width-24, 175), 2)
        pygame.draw.line(screen, black, (width-35, 185), (width-24, 185), 2)
        pygame.draw.line(screen, black, (width-35, 195), (width-24, 195), 2)
        screen.blit(test_tube, test_tube_rect)
        # points
        if points >= 100 or start_count == sec_now:
            stage = stage+1
        points_cont = timer_font.render('%d' % points, True, black)
        points_rect = points_cont.get_rect()
        points_rect.move_ip(width-points_rect.width-20, 40)
        screen.blit(points_cont, points_rect)
    elif stage == 3:
        if points >= 100:
            if play_once:
                pygame.mixer.music.load("success-fanfare-trumpets-6185.mp3")
                pygame.mixer.music.play(0)
                play_once = False
            pygame.draw.rect(screen, (255, 251, 105), (80, 140, width-160, height-280))
            pygame.draw.rect(screen, (204, 162, 0), (80, 140, width-160, height-280), 5)
            screen.blit(congratulations, congratulations_rect)
            screen.blit(you_got_100_points, you_got_100_points_rect)
            if sec_now > start_count:
                if (60+start_count-sec_now) == 1:
                    with_sec_left = with_sec_left_font.render('with 1 second to spare', True, black)
                else:
                    with_sec_left = with_sec_left_font.render('with %d seconds to spare' % (60+start_count-sec_now), True, black)
            elif sec_now <= start_count:
                if (start_count-sec_now) == 1:
                    with_sec_left = with_sec_left_font.render('with 1 second to spare', True, black)
                else:
                    with_sec_left = with_sec_left_font.render('with %d seconds to spare' % (start_count-sec_now), True, black)
            with_sec_left_rect.center = (width//2, height//2+42)
            screen.blit(with_sec_left, with_sec_left_rect)
        else:
            if play_once:
                pygame.mixer.music.load("wawawawaaa.mp3")
                pygame.mixer.music.play(0)
                play_once = False
            pygame.draw.rect(screen, (249, 115, 110), (80, 140, width-160, height-280))
            pygame.draw.rect(screen, (145, 0, 5), (80, 140, width-160, height-280), 5)
            screen.blit(failed, failed_rect)
            screen.blit(maby_next_time, maby_next_time_rect)
            if points == 1:
                you_got_points = with_sec_left_font.render('you got 1 point', True, black)
            else:
                you_got_points = with_sec_left_font.render('you got %d points' % points, True, black)
            you_got_points_rect.center = (width//2, height//2+42)
            screen.blit(you_got_points, you_got_points_rect)
    # refresh screen
    pygame.display.flip()
    pygame.time.wait(10)

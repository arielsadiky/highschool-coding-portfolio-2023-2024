def my_mp3_playlist(file_path):
    """
    makes a tuple that includs longest song name, amount of songs, popular artist.
    :param file_path: a txt file path
    :type file_path: string
    :return: longest song name, amount of songs, popular artist
    :rtype: tuple
    """
    playlist_ditail = []
    with open(file_path, "r") as my_file:
        for line in my_file:
            playlist_ditail.append(line.split(";"))
    my_max = "0"
    longest_song = ""
    for song in playlist_ditail:
        if (song[2] > my_max):
            my_max = song[2]
            longest_song = song[0]
    artists = []
    for song in playlist_ditail:
        artists.append(song[1])
    my_max = 1
    popular_artist  = ""
    for artist in artists:
        if (artists.count(artist) > my_max):
            my_max = artists.count(artist)
            popular_artist = artist
    return (longest_song, len(playlist_ditail), popular_artist)

def my_mp4_playlist(file_path, new_song):
    """
    changes therd songs name
    :param file_path: a txt file path
    :param new_song: new song name
    :type file_path: string
    :type new_song: string
    """
    playlist_ditail = []
    with open(file_path, "r") as my_file:
        for line in my_file:
            playlist_ditail.append(line.split(";"))
    while (len(playlist_ditail) < 3):
        playlist_ditail.append([])
    playlist_ditail[2][0] = new_song
    with open(file_path, "w") as my_file:
        for line in playlist_ditail:
            my_file.write("%s;%s;%s;%s" % tuple(line))
    

def main():
    file = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\playlist.txt"
    help(my_mp3_playlist)
    print(my_mp3_playlist(file))
    
    help(my_mp4_playlist)
    my_mp4_playlist(file, "Python Love Story")

if __name__ == "__main__":
    main()
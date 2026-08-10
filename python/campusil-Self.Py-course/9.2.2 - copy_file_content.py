def copy_file_content(source, destination):
    """
    copy source files content to destination file 
    :param source: a txt file path
    :param destination: a txt file path
    :type source: string
    :type destination: string
    """
    with open(source, "r") as source_file:
        copy = source_file.read()
    with open(destination, "w") as destination_file:
        destination_file.write(copy)

def main():
    help(copy_file_content )
    copy_path = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\new 1.txt"
    past_path = r"c:\Users\ariel\OneDrive\Documents\High School\Computer Science\python - NotePad++\past.txt"
    
    copy_file_content(copy_path, past_path)
    

if __name__ == "__main__":
    main()
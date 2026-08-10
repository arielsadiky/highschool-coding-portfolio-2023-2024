def sort_anagrams(list_of_strings):
    """
    makes a list with lists insid it with 
    anagrams from the param list_of_strings 
    in the order they are presented in list_of_strings.
    :param list_of_strings: a list of strings
    :type list_of_strings: list
    :return: a list that contains lists of anagrams
    :rtype: list
    """
    list_of_anagram_lists = []
    for i in list_of_strings:
        has_anagram = False
        for j in list_of_anagram_lists:
            if (sorted(i) == sorted(j[0])):
                has_anagram = True
                j.append(i)
        if (not has_anagram):
            list_of_anagram_lists.append([i])
    return list_of_anagram_lists

def main():
    help(sort_anagrams)
    list_of_words = ['deltas', 'retainers', 'desalt', 'pants',
    'slated', 'generating', 'ternaries', 'smelters', 'termless',
    'salted', 'staled', 'greatening', 'lasted', 'resmelts']
    print(sort_anagrams(list_of_words))

if __name__ == "__main__":
    main()
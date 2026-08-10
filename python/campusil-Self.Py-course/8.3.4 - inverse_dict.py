def inverse_dict(my_dict):
    """
    maeks a new dict that has the old dicts 
    keys as vakuse and vakues as keys.
    :param my_dict: a dict
    :type my_dict: dict
    :return: inverted dict
    :rtype: dict
    """
    inverted_dict = {}
    for i in my_dict.values():
        inverted_dict[i] = []
    for i in inverted_dict.keys():
        for j in my_dict.keys():
            if (my_dict[j] == i):
                inverted_dict[i].append(j)
    for i in inverted_dict.keys():
        inverted_dict[i].sort()
    return inverted_dict

def main():
    help(inverse_dict)
    course_dict = {'I': 3, 'love': 3, 'self.py!': 2, 'a': 1, 'B': 3}
    print(inverse_dict(course_dict))

if __name__ == "__main__":
    main()
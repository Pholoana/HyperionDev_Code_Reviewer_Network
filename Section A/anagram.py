# creating an array of Strings
strs = ['eat', 'tea',  'tan',  'ate', 'nat', 'bat']

# defining and Anagram function to hold our reference Strings
# breaking down our strings into characters
def createAnagramRef(string):
    ref = ''
    for ch in sorted(string):
        ref += ch
    return str(ref)

# defining an anagram function to group our strings
def groupAnagramWords(strs):
    group = dict()
    for i in strs:
        if group.get(createAnagramRef(i)) == None:
            group[createAnagramRef(i)] = [i]
        else:
            group[createAnagramRef(i)].append(i)
    return group

# putting our grouped strings in a single variable 
anagram_grouped = groupAnagramWords(strs)

# creating a list of grouped lists
anagram_grouped_list = list()
 
for y, x in anagram_grouped.items():
    anagram_grouped_list.append(x)
    
# printing our list of grouped lists
print(anagram_grouped_list)

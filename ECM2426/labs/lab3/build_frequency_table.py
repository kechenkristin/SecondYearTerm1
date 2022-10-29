#!/usr/bin/python3
import codecs
import operator

# read the content of cipher.txt into the variable ciphertext
ciphertext = codecs.open('ciphertext.txt', encoding='utf-8').read()

# build the frequency table, using a Python dictionary
frequency={}
for c in ciphertext:
    if c in frequency:
      frequency[c] += 1
    else:
      frequency[c] = 0

# sort the dictionary by frequency (items of the dictionary)
sorted_frequency = sorted(frequency.items(), key=operator.itemgetter(1))

print(sorted_frequency[::-1])

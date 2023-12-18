                                                       𝐖𝐎𝐑𝐃_𝐂𝐎𝐌𝐏𝐎𝐒𝐈𝐓𝐈𝐎𝐍_𝐒𝐎𝐋𝐔𝐓𝐈𝐎𝐍
________________________________________________________________________________________________________________________________________________________________________________
𝐎𝐕𝐄𝐑𝐕𝐈𝐄𝐖 :
The program reads a list of words from a file, inserts them into a Trie data structure, and then iterates through each word to identify compound words.
The Trie structure aids in quick word retrieval and checking for compound words by recursively examining prefixes and suffixes.

𝐇𝐎𝐖 𝐓𝐎 𝐑𝐔𝐍 ?
1.Clone the Repository:
git clone https://github.com/sneha100verma/Word-Composition
cd Word_Composition
2.Compile and Run:
javac WordCombination.java
java WordCombination

𝐃𝐄𝐒𝐈𝐆𝐍 𝐃𝐄𝐂𝐈𝐒𝐈𝐎𝐍𝐒 :
Trie Data Structure: The use of a Trie allows for efficient storage and retrieval of words, optimizing the process of identifying compound words.
Recursive Check for Compound Words: Using recursion to check whether a given word is a compound word by analyzing its prefixes and suffixes.
Tracking Longest and Second-Longest: The program keeps track of the longest and second-longest compound words encountered during the iteration.

𝐖𝐎𝐑𝐊𝐈𝐍𝐆 𝐀𝐏𝐏𝐑𝐎𝐀𝐂𝐇 :
Implements a Trie, a tree-like structure, for efficient storage and retrieval of words.
Trie aids in quick and organized access to words in the list.
Examines each word systematically to determine if it can be formed by combining smaller words.
Utilizes a recursive approach to explore different combinations of prefixes and suffixes within each word.
Then, identifies the longest and second-longest compound words.
Constantly tracks and updates the results accordingly.

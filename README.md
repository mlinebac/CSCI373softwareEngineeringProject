CSCI 373: Software Engineering. Term Project.
 
Team 1: Adam McCann, Ryan Fairbanks, Matt Lineback, Felicia Buchanan
12/12/16
 
 This program generates a window interface with a family tree. There are five buttons at the top with the family tree displayed at the top. These five buttons are "Add Person", "Remove Person", "Delete Tree", "Print Tree", and "Edit Person". Double clicking on any person in the tree will allow the name to be edited. Pressing the enter will save the change, otherwise the change will not be made to the person.
 The "Add Person" button allows the user to add a person to the family tree as a child of the person that was clicked last.
 The "Remove Person" button allows the user to delete the person in the family tree that was clicked last.
 The "Delete Tree" button allows the user to delete the entire family tree, aside from the root node called "First Known Ancestor" by default.
 The "Print Tree" button allows the user to print the entire tree to a jpeg file. The first created file will be named tree.jpg for each initialization of the program. After that the "tree" part of the name will be followed by an incremented number. For example tree1.jpg.
 The "Edit Person" button allows the user to edit the attributes of a family member including their birth date, place of birth, death date, place of death, parent (the one not shown in the tree), their first spouse, their second spouse, and their occupation. This is displayed in a separate window from the one that the tree and buttons are displayed in.
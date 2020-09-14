# Branching Story to Graph ADT

Suppose we wanted to generalize the BranchingStory class from the interactive story example to be an abstract data type (ADT) that supported representing a directed graph with connections between any object.

1. How would you go about making this change? What operations would your ADT support?
   _I would change the references to a Scene in this class to an Object, to support creating and linking different Object types, not just Scene objects. I would also rename the attributes and methods to support a more general directed graph, replacing story and scene._

   _The Scene class could be modified as a ObjectNode class, to represent each Object in the graph, this class would contain an ArrayList of the available choices that each object containsas well as the Object being referenced (instead of the text string used in BranchingStories). Each Choice would contain the String to represent the choice and a reference to the ObjectNode it links to._

   _This would support the following operations:_
   _addObject_
   _removeObject_
   _addOption to an object_
   _removeOption to an object_
   _get/set option text_
   _get/set option link_

2. What is an advantage of using an ADT in this context?
   _Creatng a more generalised, higher level directed graph makes it easier to implement for multiple purposes and also the code becomes easier to work with._
   _Generalising the the class to an ADT also means that changes can be made to the new class without having to alter the objects it includes._

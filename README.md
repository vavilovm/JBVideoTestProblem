# JBVideoTestProblem

```
class Node {  
    val value: String  
    val nodes: List<Node>  
}
```

Console app to create, edit, save to a file (and restore from a file) `Node` structure.

```
API:

* h | help                        -- print help 
* q | quit                        -- stop the program   
* s | saveTo   FILENAMES          -- save current structure to given files  
* l | loadFrom FILENAMES          -- add everything from given files (without removing current structure)  
* v | values                      -- print all values  
* n | nodesOf  VALUES             -- print all values from every given node  
* create       VALUES             -- create nodes with given values. Does nothing if a node already exists  
* add          value    VALUES    -- create nodes with all given values and adds everything to the first one's list  
* clear                           -- delete all nodes  
```

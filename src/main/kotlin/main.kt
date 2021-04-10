import java.util.*

fun main() {
    val input: Sequence<String> = generateSequence(::readLine)


    val help =
        """API:
q | quit                        -- stop the program
h | help                        -- print help
create       VALUES             -- create nodes with given values. Does nothing if a node already exists
add          value    VALUES    -- create nodes with all given values and adds everything to the first one's list
clear                           -- delete all nodes
s | saveTo   FILENAMES          -- save current structure to given files
l | loadFrom FILENAMES          -- add everything from given files (without removing current structure)
v | values                      -- print all values
n | nodesOf  VALUES             -- print all values from every given node
"""


    val nodeManager = NodeManager()
    for (s in input) {
        val scanner = Scanner(s)
        if (!scanner.hasNext()) continue

        when (scanner.next()) {
            "q", "quit" -> break
            "h", "help" -> println(help)
            "create" -> {
                while (scanner.hasNext()) {
                    nodeManager.create(scanner.next())
                }
            }
            "add" -> {
                if (!scanner.hasNext()) continue
                val head = scanner.next()
                while (scanner.hasNext()) {
                    nodeManager.add(head, scanner.next())
                }
            }
            "clear" -> nodeManager.clear()
            "s", "saveTo" -> {
                while (scanner.hasNext()) {
                    nodeManager.saveTo(scanner.next())
                }
            }
            "l", "loadFrom" -> {
                while (scanner.hasNext()) {
                    nodeManager.loadFrom(scanner.next())
                }
            }
            "v", "values" -> println(nodeManager.values())
            "n", "nodesOf" -> {
                while (scanner.hasNext()) {
                    println(nodeManager.valueListOf(scanner.next()))
                }
            }
            else -> {
            }
        }
    }


}
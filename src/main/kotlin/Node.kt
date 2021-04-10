import java.io.File

data class Node(val value: String, val nodes: MutableList<Node>) {
    constructor(v: String) : this(v, mutableListOf())

    fun add(other: Node) = nodes.add(other)
}

class NodeManager {
    private val map = mutableMapOf<String, Node>()


    fun create(vararg values: String) {
        for (value in values)
            map.putIfAbsent(value, Node(value))
    }

    // creates nodes if they do not exist
    fun add(value1: String, vararg values: String) {
        create(value1, *values)

        val node1: Node = map[value1]!!
        for (value2 in values) {
            val node2 = map[value2]
            node1.add(node2!!)
        }
    }

    fun clear() {
        map.clear()
    }

    fun valueListOf(value: String) =
        map[value]?.nodes?.map(Node::value) ?: listOf()

    fun values() =
        map.values.map(Node::value)

    fun saveTo(filename: String) {
        File(filename).printWriter().use { out ->
            out.println(map.size)
            for (node in map.values) {
                out.println(node.value)
                out.println(node.nodes.size)

                for (child in node.nodes) {
                    out.println(child.value)
                }
            }
        }
    }

    fun loadFrom(filename: String) {
        val lines = File(filename).readLines()

        val numberOfNodes = lines[0].toInt()
        var currentIndex = 1
        for (i in 1..numberOfNodes) {
            val rootValue = lines[currentIndex++]
            create(rootValue)

            val numberOfChildren = lines[currentIndex++].toInt()
            for (j in 1..numberOfChildren) {
                val childValue = lines[currentIndex++]
                create(childValue)
                add(rootValue, childValue)
            }
        }

    }
}

package ru.nstu.stud.koroleva2019

abstract class AbstractFileSystemNode(
    private var name: String,
    parent: FileSystemNode?,
    private val fileFlag: Boolean = false,
) : FileSystemNode {

    private var parent: FileSystemNode?

    init {
        this.parent = getValidParent(parent)
    }

    private fun getValidParent(parent: FileSystemNode?): FileSystemNode? {
        return when (parent) {
            null -> null
            !is Folder -> {
                println("Only Folder can be the parent. Select parent = null.")
                null
            }
            else -> parent
        }
    }

    override fun getParentNode() = parent

    override fun getPath(): String {
        var node: FileSystemNode? = this

        val path = StringBuilder()
        while ((node?.getParentNode()) != null) {
            path.insert(0, "\\${node.getName()}")
            node = node.getParentNode()
        }
        path.insert(0, "${node?.getName()}")

        if (!fileFlag) path.append("\\")

        return path.toString()
    }

    override fun getName() = name

    fun replace(newParent: FileSystemNode?) {
        parent = newParent
    }
}
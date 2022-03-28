package ru.nstu.stud.koroleva2019

/**
 * Folder
 * если явно не указать аргумент parent,
 * сработает конструктор с children
 */

class Folder(
    name: String = "untitled",
    parent: FileSystemNode? = null,
) : AbstractFileSystemNode(name, parent) {

    private val children = ArrayList<FileSystemNode>()

    init {
        if (getParentNode() != null) {
            (parent as Folder).children.add(this)
        }
    }

    constructor(name: String, vararg children: FileSystemNode) : this(name) {
        for (c: FileSystemNode in children) {
            this.children.add(c)

            if (c is AbstractFileSystemNode) {
                val child: AbstractFileSystemNode = c

                //по моей реализации только Folder может быть родителем
                val parentFolder: Folder? = child.getParentNode() as Folder?
                parentFolder?.getChildrenArray()?.remove(child)
                child.replace(this)
            }
        }
    }

    fun getChildrenString(): String {
        val childrenString = StringBuilder()
        for (child: FileSystemNode in children) {
            childrenString.append("${child.getName()}; ")
        }
        return childrenString.toString()
    }

    fun getChildrenArray() = children
}
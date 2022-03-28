package ru.nstu.stud.koroleva2019

class File(
    name: String = "untitled",
    parent: FileSystemNode? = null,
) : AbstractFileSystemNode(name, parent, true) {

    init {
        if (getParentNode() != null) {
            (parent as Folder).getChildrenArray().add(this)
        }
    }

    fun getFileExtension(): String {
        val dotIndex: Int = this.getName().lastIndexOf('.');
        if (dotIndex == -1) return "";
        return this.getName().substring(dotIndex);
    }
}
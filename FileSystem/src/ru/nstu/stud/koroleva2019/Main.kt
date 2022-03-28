package ru.nstu.stud.koroleva2019

fun main() {
    val rootFolder1 = Folder("rootFolder")
    val subFolder1 = Folder("subFolder1", parent = rootFolder1)
    val subFolder2 = Folder("subFolder2", parent = subFolder1)
    val subFolder3 = Folder("subFolder3", parent = subFolder1)

    println("Testing getPath():")
    println(rootFolder1.getPath())
    println(subFolder1.getPath())
    println(subFolder2.getPath())
    println(subFolder3.getPath())
    println()

    val file1 = File(parent = rootFolder1)
    val file2 = File("file2.doc", rootFolder1)
    val file3 = File("file3.txt", subFolder2)

    println(file1.getPath())
    println(file2.getPath())
    println(file3.getPath())
    println()

    println("Testing getChildrenString():")
    println("rootFolder children:\n     ${rootFolder1.getChildrenString()}")
    println("subFolder1 children:\n     ${subFolder1.getChildrenString()}")
    println()

    println("Testing create folder in file:")
    val folderInFile = Folder("folder", parent = file1)
    println(folderInFile.getPath())
    println()

    println("\nTesting getFileExtension():")
    println("${file1.getName()}: ${file1.getFileExtension()}")
    println("${file2.getName()}: ${file2.getFileExtension()}")
    println("${file3.getName()}: ${file3.getFileExtension()}")
    println()

    println("\nTesting create new Folder with children:")
    val newRootFolder = Folder("newRootFolder", file1, subFolder2, subFolder3)
    println(newRootFolder.getName())
    println(file1.getPath())
    println(subFolder2.getPath())
    println(subFolder3.getPath())
    println()
    println("newRootFolder children:\n     ${newRootFolder.getChildrenString()}")
    println("rootFolder children:\n     ${rootFolder1.getChildrenString()}")
    println(file3.getPath())
    println()
}
package ru.nstu.stud.koroleva2019

interface FileSystemNode {
    fun getParentNode(): FileSystemNode?

    fun getPath(): String

    fun getName(): String
}
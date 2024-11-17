package com.aram.mehrabyan.utils.mapper

abstract class Mapper<in INPUT, out OUTPUT> {

    abstract fun map(input: INPUT): OUTPUT

    fun map(input: List<INPUT>): List<OUTPUT> {
        return input.map { map(it) }
    }
}

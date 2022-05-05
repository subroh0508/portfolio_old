package routes

import com.arkivanov.essenty.parcelable.Parcelable

sealed class Page private constructor(val path: String) : Parcelable {
    object Introduction : Page(BasePath.INTRODUCTION.toString())
    object Biography : Page(BasePath.BIOGRAPHY.toString())
    object Skill : Page(BasePath.SKILL.toString())
    data class Works(val index: Int = 0) : Page("${BasePath.WORKS}?p=$index")
    data class Speaks(val index: Int = 0) : Page("${BasePath.SPEAKS}?p=$index")
    object Link : Page(BasePath.LINK.toString())

    fun label() = this::class.simpleName ?: ""

    companion object {
        operator fun invoke(base: String, query: String?): Page {
            val index = """p=(\d)""".toRegex().find(query ?: "")?.value?.toIntOrNull()
            val basePath = BasePath.values().find {
                base == "/${it.toString().split("?").first()}"
            }

            return when (basePath) {
                BasePath.BIOGRAPHY -> Biography
                BasePath.SKILL -> Skill
                BasePath.WORKS -> Works(index ?: 0)
                BasePath.SPEAKS -> Speaks(index ?: 0)
                BasePath.LINK -> Link
                else -> Introduction
            }
        }
        operator fun invoke(path: String): Page {
            val (base, query) = path.split("?").let {
                it.first() to it.lastOrNull()
            }

            return invoke(base, query)
        }

        fun forMenu() = listOf(
            Introduction,
            Biography,
            Skill,
            Works(),
            Speaks(),
            Link,
        )
    }
}

private enum class BasePath(private val path: String) {
    INTRODUCTION("/"),
    BIOGRAPHY("biography"),
    SKILL("skill"),
    WORKS("works"),
    SPEAKS("speaks"),
    LINK("link");

    override fun toString() = path
}

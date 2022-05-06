package routes

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import org.w3c.dom.url.URL
import kotlin.random.Random

sealed class Page private constructor(val path: String) : Parcelable {
    @Parcelize
    object Introduction : Page(BasePath.INTRODUCTION.toString())
    @Parcelize
    object Biography : Page(BasePath.BIOGRAPHY.toString())
    @Parcelize
    object Skill : Page(BasePath.SKILL.toString())
    @Parcelize
    data class Works(val index: Int = 0) : Page("${BasePath.WORKS}?p=$index")
    @Parcelize
    data class Speaks(val index: Int = 0) : Page("${BasePath.SPEAKS}?p=$index")
    @Parcelize
    object Link : Page(BasePath.LINK.toString())

    fun label() = when (this) {
        is Introduction -> "Home"
        else -> this::class.simpleName ?: ""
    }


    companion object {
        operator fun invoke(href: String?): Page {
            href ?: return Introduction

            val (base, index) = URL(href).let {
                it.pathname to it.searchParams.get("p")?.toIntOrNull()
            }

            return when (BasePath.values().find { base == "/$it" }) {
                BasePath.BIOGRAPHY -> Biography
                BasePath.SKILL -> Skill
                BasePath.WORKS -> Works(index ?: 0)
                BasePath.SPEAKS -> Speaks(index ?: 0)
                BasePath.LINK -> Link
                else -> Introduction
            }
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

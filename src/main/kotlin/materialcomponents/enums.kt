@file:Suppress("EnumEntryName")

package materialcomponents

enum class AvatarSize {
    xsmall,
    small,
    medium,
    large,
    xlarge
}

fun AvatarProps.size(v: AvatarSize) { size = v.name }

enum class TypographyUse {
    headline1,
    headline2,
    headline3,
    headline4,
    headline5,
    headline6,
    subtitle1,
    subtitle2,
    body1,
    body2,
    caption,
    button,
    overline
}

fun TypographyProps.use(v: TypographyUse) { use = v.name }

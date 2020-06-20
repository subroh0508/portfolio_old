package materialcomponents.delegates

import kotlin.reflect.KProperty

external fun delete(p: dynamic): Boolean = definedExternally

class OptionsProperty<R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T? = asDynamic()[property.name] as? T

    operator fun setValue(thisRef: R, property: KProperty<*>, value: T?) {
        if (value == null) {
            delete(asDynamic()[property.name])
            return
        }

        asDynamic()[property.name] = value.toString()
    }
}

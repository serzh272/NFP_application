package ru.serzh272.nfp.norms.delegate

import ru.serzh272.nfp.norms.NormsViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun selectedIds() = object : ReadWriteProperty<NormsViewModel, Set<Long>> {
    override fun getValue(thisRef: NormsViewModel, property: KProperty<*>): Set<Long> {
        return thisRef.savedStateHandle[property.name] ?: setOf()
    }

    override fun setValue(thisRef: NormsViewModel, property: KProperty<*>, value: Set<Long>) {
        thisRef.savedStateHandle[property.name] = value
    }
}

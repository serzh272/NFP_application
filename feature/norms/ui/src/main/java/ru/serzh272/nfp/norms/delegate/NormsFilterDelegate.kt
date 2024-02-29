package ru.serzh272.nfp.norms.delegate

import androidx.lifecycle.SavedStateHandle
import ru.serzh272.nfp.norms.NormsViewModel
import ru.serzh272.nfp.norms.model.ExerciseUi
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NormsFilterDelegate : ReadWriteProperty<NormsViewModel, Set<Long>> {

    override fun getValue(thisRef: NormsViewModel, property: KProperty<*>): Set<Long> {
        return thisRef.savedStateHandle[property.name] ?: setOf()
    }

    override fun setValue(thisRef: NormsViewModel, property: KProperty<*>, value: Set<Long>) {
        thisRef.savedStateHandle[property.name] = value
    }
}

fun selectedIds() = NormsFilterDelegate()

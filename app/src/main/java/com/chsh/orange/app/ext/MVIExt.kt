package com.chsh.orange.app.ext

import androidx.lifecycle.*
import androidx.lifecycle.map
import kotlinx.coroutines.channels.Channel
import kotlin.reflect.KProperty1

fun <T,A> LiveData<T>.observeState(
    lifecycleOwner : LifecycleOwner,
    prop1:KProperty1<T,A>,
    action : (A) ->Unit){
    this.map {
        OrangeTuple1(prop1.get(it))
    }.distinctUntilChanged().observe(lifecycleOwner, Observer { (a) ->
        action(a)
    })
}

fun <T,A,B> LiveData<T>.observeState(
    lifecycleOwner : LifecycleOwner,
    prop1:KProperty1<T,A>,
    prop2: KProperty1<T, B>,
    action : (A,B) ->Unit){
    this.map {
        OrangeTuple2(prop1.get(it),prop2.get(it))
    }.distinctUntilChanged().observe(lifecycleOwner, Observer { (a,b) ->
        action(a,b)
    })
}


internal data class StateTuple1<A>(val a: A)
internal data class OrangeTuple1<A>(val a : A)
internal data class OrangeTuple2<A,B>(val a : A,val b:B)
internal data class OrangeTuple3<A,B,C>(val a : A,val b :B,val c:C)

fun <T> MutableLiveData<T>.setState(reducer : T.()->T){
    this.value = this.value?.reducer()
}

suspend fun<T> Channel<T>.setEvent(value : T){
    send(value)
}

suspend fun<T> Channel<T>.setEvent(vararg values : T){
    for (value in values) {
        send(value)
    }
}

fun<T,R> withState(state: LiveData<T>,block : (T)->R) : R? {
    return state.value?.let(block)
}
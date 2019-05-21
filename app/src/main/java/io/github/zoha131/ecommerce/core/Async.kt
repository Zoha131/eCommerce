package io.github.zoha131.ecommerce.core

sealed class Async

object Loading : Async()

object Success : Async()

class Failed(val error: Throwable): Async()
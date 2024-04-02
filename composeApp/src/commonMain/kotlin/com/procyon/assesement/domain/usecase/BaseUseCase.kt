package com.procyon.assesement.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
abstract class BaseUseCase<IN, OUT>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(param: IN): Result<OUT> {
        return withContext(dispatcher) {
            try {
                Result.success(block(param))
            } catch (ex: Exception) {
                Result.failure(ex)
            }
        }
    }

    abstract suspend fun block(param: IN): OUT

}
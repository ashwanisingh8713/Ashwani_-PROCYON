package com.procyon.assesement.di

import com.procyon.assesement.presentation.userinfo.UserInfoViewModel
import com.procyon.assesement.data.model.UserInfoInput
import com.procyon.assesement.data.repo.UserInfoRepoImpl
import com.procyon.assesement.domain.repo.IUserInfoRepo
import com.procyon.assesement.domain.usecase.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Created by Ashwani Kumar Singh on 01,April,2024.
 */
fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(
            viewModelModule,
            useCasesModule,
            repositoryModule,
            dataSourceModule,
            dispatcherModule,
        )
    }
}

val viewModelModule = module {
    single { UserInfoViewModel(get()) }
}

val useCasesModule: Module = module {
    factory { UserInfoUseCase(get(), get()) }
}

val repositoryModule = module {
    single<IUserInfoRepo> { UserInfoRepoImpl(get()) }
}

val dataSourceModule = module {
    single<UserInfoInput> { UserInfoInput(id = 1,
        name = "Sheeba N.", price = "$36", source = "Booking",
    )
    }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}

fun initKoin() = initKoin {}
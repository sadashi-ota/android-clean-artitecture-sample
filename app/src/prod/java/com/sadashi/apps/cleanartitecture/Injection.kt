package com.sadashi.apps.cleanartitecture

import com.sadashi.apps.cleanartitecture.externals.infra.QiitaRemoteDataSource
import com.sadashi.apps.cleanartitecture.gateways.QiitaRepository
import com.sadashi.apps.cleanartitecture.presenters.MainContract
import com.sadashi.apps.cleanartitecture.presenters.MainPresenter
import com.sadashi.apps.cleanartitecture.usecases.QiitaUseCase
import com.sadashi.apps.cleanartitecture.usecases.QiitaUseCasePort

object Injection {

    fun provideMainPresenter(view: MainContract.View): MainPresenter {
        val presenter = MainPresenter(view)
        val repository = provideQiitaRepository()
        val useCase = provideQiitaUseCase(repository, presenter)
        repository.useCaseInput = useCase
        presenter.useCaseInput = useCase
        return presenter
    }

    fun provideQiitaRepository(): QiitaRepository {
        return QiitaRepository(QiitaRemoteDataSource())
    }

    fun provideQiitaUseCase(outputFromPresenter: QiitaUseCasePort.OutputFromPresenter,
                            outputFromRepository: QiitaUseCasePort.OutputFromRepository
    ): QiitaUseCase {
        return QiitaUseCase(outputFromPresenter, outputFromRepository)
    }
}
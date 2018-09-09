package com.sadashi.apps.cleanartitecture.usecases

import com.sadashi.apps.cleanartitecture.entities.QiitaTag

class QiitaUseCase(
        private val outputFromPresenter: QiitaUseCasePort.OutputFromPresenter,
        private val outputFromRepository: QiitaUseCasePort.OutputFromRepository
) : QiitaUseCasePort.InputFromPresenter, QiitaUseCasePort.InputFromRepository {

    override fun doLoadTags(page: Int) {
        outputFromPresenter.doLoadTags(page)
    }

    override fun didLoadTags(tags: List<QiitaTag>) {
        outputFromRepository.didLoadTags(tags)
    }

    override fun didLoadTagsError(t: Throwable) {
        outputFromRepository.didLoadTagsError(t)
    }

}
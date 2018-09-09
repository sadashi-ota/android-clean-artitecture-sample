package com.sadashi.apps.cleanartitecture.usecases

import com.sadashi.apps.cleanartitecture.entities.QiitaTag

/*
 * Interface for QiitaUseCase.
 * やることがないとただの土管になるので、InputとOutputのIFが同じになる。。。
 */
interface QiitaUseCasePort {
    interface InputFromPresenter {
        fun doLoadTags(page: Int)
    }

    interface OutputFromPresenter {
        fun doLoadTags(page: Int)
    }

    interface InputFromRepository {
        fun didLoadTags(tags: List<QiitaTag>)
        fun didLoadTagsError(t: Throwable)
    }

    interface OutputFromRepository {
        fun didLoadTags(tags: List<QiitaTag>)
        fun didLoadTagsError(t: Throwable)
    }
}
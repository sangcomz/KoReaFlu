package xyz.sangcomz.koreaflu.flux.actions

import com.hardsoftstudio.rxflux.action.RxAction

/**
 * Created by Seok-Won on 8/30/16.
 */
interface Actions {
    fun getPublicRepositories()

    fun retry(action: RxAction): Boolean
}
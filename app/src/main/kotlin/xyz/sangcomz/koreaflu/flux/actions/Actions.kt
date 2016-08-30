package xyz.sangcomz.koreaflu.flux.actions

import com.hardsoftstudio.rxflux.action.RxAction

/**
 * Created by Seok-Won on 8/30/16.
 */
interface Actions {
    val GET_PUBLIC_REPOS: String
        get() = "get_public_repos"

    val GET_USER: String
        get() = "get_user"

    companion object {
        val GET_PUBLIC_REPOS: String
            get() = "get_public_repos"

        val GET_USER: String
            get() = "get_user"
    }


    fun getPublicRepositories()

    fun getUserDetails(userId: String)

    fun retry(action: RxAction): Boolean
}
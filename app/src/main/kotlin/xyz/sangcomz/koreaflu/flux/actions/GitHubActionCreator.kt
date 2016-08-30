import com.hardsoftstudio.rxflux.action.RxAction
import com.hardsoftstudio.rxflux.action.RxActionCreator
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.util.SubscriptionManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import xyz.sangcomz.koreaflu.api.GitHubApi
import xyz.sangcomz.koreaflu.flux.actions.Actions
import xyz.sangcomz.koreaflu.flux.actions.Keys

class GitHubActionCreator(dispatcher: Dispatcher, manager: SubscriptionManager) :
        RxActionCreator(dispatcher, manager), Actions {
    override fun getPublicRepositories() {
        val action = newRxAction(GET_PUBLIC_REPOS)
        if (hasRxAction(action)) return
        addRxAction(action,
                GitHubApi
                        .Factory
                        .getApi()
                        .repositories
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            repoList ->
                            postRxAction(newRxAction(GET_PUBLIC_REPOS,
                                    Keys.PUBLIC_REPOS,
                                    repoList))
                        }, {
                            throwable ->
                            postError(action, throwable)
                        }))
    }

    override fun getUserDetails(userId: String) {
        val action = newRxAction(GET_USER, Keys.ID, userId)
        if (hasRxAction(action)) return

        addRxAction(action,
                GitHubApi
                        .Factory
                        .getApi()
                        .getUser(userId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ user ->
                            action.data.put(Keys.USER, user)
                            postRxAction(action)
                        })
                        { throwable ->
                            postError(action, throwable)
                        })
    }

    override fun retry(action: RxAction): Boolean {
        if (hasRxAction(action)) return true

        when (action.type) {
            GET_USER -> {
                getUserDetails(action.get(Keys.ID))
                return true
            }
            GET_PUBLIC_REPOS -> {
                getPublicRepositories()
                return true
            }
        }
        return false
    }

}
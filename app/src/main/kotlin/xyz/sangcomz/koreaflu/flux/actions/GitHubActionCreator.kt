package xyz.sangcomz.koreaflu.flux.actions


import android.util.Log
import com.hardsoftstudio.rxflux.action.RxAction
import com.hardsoftstudio.rxflux.action.RxActionCreator
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.util.SubscriptionManager
import io.realm.Realm
import io.realm.RealmResults
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import xyz.sangcomz.koreaflu.api.GitHubApi
import xyz.sangcomz.koreaflu.flux.model.GitHubRepo

class GitHubActionCreator(dispatcher: Dispatcher, manager: SubscriptionManager) :
        RxActionCreator(dispatcher, manager), Actions {
    override fun getPublicRepositories() {
        Log.d("GitHubActionCreator", "getPublicRepositories")
        val action = newRxAction(Keys.ACTION_GET_PUBLIC_REPOS)
        if (hasRxAction(action)) return
        addRxAction(action,
                GitHubApi
                        .Factory
                        .getApi()
                        .repositories
                        .subscribeOn(Schedulers.newThread())
                        .map {
                            Log.d("GitHubActionCreator", "repo size = ${it.size}")
                            val mRealm: Realm = Realm.getDefaultInstance()
                            mRealm.beginTransaction()
                            mRealm.insertOrUpdate(it)
                            mRealm.commitTransaction()
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap {
                            getRepoListInRealmObservable()
                        }
                        .subscribe({
                            repoList ->
                            Log.d("GitHubActionCreator", "repoList size = ${repoList.size}")
                            postRxAction(newRxAction(Keys.ACTION_GET_PUBLIC_REPOS,
                                    Keys.PUBLIC_REPOS,
                                    repoList))
                            removeRxAction(action)
                        }, {
                            throwable ->
                            postError(action, throwable)
                            removeRxAction(action)
                        }))
    }

    override fun retry(action: RxAction): Boolean {
        if (hasRxAction(action)) return true
        when (action.type) {
            Keys.ACTION_GET_PUBLIC_REPOS -> {
                getPublicRepositories()
                return true
            }
        }
        return false
    }

    private fun getRepoListInRealmObservable(): Observable<RealmResults<GitHubRepo>>? {
        Log.d("GitHubActionCreator", "getRepoListInRealmObservable")
        val mRealm: Realm = Realm.getDefaultInstance()
        return mRealm
                .where(GitHubRepo::class.java)
                .findAll()
                .asObservable()


    }

}
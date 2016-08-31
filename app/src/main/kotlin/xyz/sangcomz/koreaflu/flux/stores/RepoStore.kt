package xyz.sangcomz.koreaflu.flux.stores

import android.util.Log
import com.hardsoftstudio.rxflux.action.RxAction
import com.hardsoftstudio.rxflux.dispatcher.Dispatcher
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange
import io.realm.RealmResults
import xyz.sangcomz.koreaflu.flux.actions.Keys
import xyz.sangcomz.koreaflu.flux.model.GitHubRepo

/**
 * Created by Seok-Won on 8/31/16.
 */
class RepoStore(dispatcher: Dispatcher) : RxStore(dispatcher), RepoStoreInterface {
    //Store Id
    val ID = "RepoStore"

    private var instance: RepoStore? = null
    private var repoList: RealmResults<GitHubRepo>? = null
    override fun onRxAction(action: RxAction?) {
        Log.d("RepoStore", "onRxAction")
        action?.let {
            when (it.type) {
                Keys.ACTION_GET_PUBLIC_REPOS ->
                    this.repoList = action.get(Keys.PUBLIC_REPOS)
                else // IMPORTANT if we don't modify the store just ignore
                -> return
            }
            postChange(RxStoreChange(ID, action))
        }
    }

    override fun getRepo(): RealmResults<GitHubRepo>? = repoList ?: null

}
package xyz.sangcomz.koreaflu.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.hardsoftstudio.rxflux.action.RxError
import com.hardsoftstudio.rxflux.dispatcher.RxViewDispatch
import com.hardsoftstudio.rxflux.store.RxStore
import com.hardsoftstudio.rxflux.store.RxStoreChange
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*
import xyz.sangcomz.koreaflu.App
import xyz.sangcomz.koreaflu.R
import xyz.sangcomz.koreaflu.flux.actions.GitHubActionCreator
import xyz.sangcomz.koreaflu.flux.model.GitHubRepo
import xyz.sangcomz.koreaflu.flux.stores.RepoStore
import xyz.sangcomz.koreaflu.ui.main.adapter.RepoAdapter


class MainActivity : AppCompatActivity(), RxViewDispatch {

    var repoStore: RepoStore? = null
    var githubAction: GitHubActionCreator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAction()
        githubAction?.let {
            it.getPublicRepositories()
        }
    }

    fun initAction() {
        githubAction = (application as App).getGitHubActionCreator()
    }

    fun setRepoList(repoList: RealmResults<GitHubRepo>) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = RepoAdapter(repoList)
    }

    override fun onRxViewUnRegistered() {
    }

    override fun onRxStoreChanged(change: RxStoreChange) {
        Log.d("MainActivity", "onRxStoreChanged")
        repoStore?.let {
            when (change.storeId) {
                it.ID -> {
                    it.getRepo()?.let { repoList ->
                        setRepoList(repoList)
                    }
                }
                else -> return


            }
        }

    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore>? {
        return null
    }

    override fun onRxViewRegistered() {
    }

    override fun onRxError(error: RxError) {
    }

    override fun getRxStoreListToRegister(): MutableList<RxStore>? {
        val rxStoreList: MutableList<RxStore> = arrayListOf()
        val rxFlux = (application as App).getRxFlux()
        rxFlux?.let {
            repoStore = RepoStore(it.dispatcher)
            repoStore?.let {
                rxStoreList.add(it)
            }
        }
        return rxStoreList
    }

}

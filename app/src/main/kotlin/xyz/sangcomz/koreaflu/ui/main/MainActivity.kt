package xyz.sangcomz.koreaflu.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
    }


    override fun onResume() {
        super.onResume()
        refresh()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            val id = it.itemId
            when (id) {
                R.id.action_refresh -> {
                    refresh()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun refresh() {
        githubAction?.let {
            setLoadingFrame(true)
            it.getPublicRepositories()
        }
    }

    fun initAction() {
        githubAction = (application as App).getGitHubActionCreator()
    }

    fun setRepoList(repoList: RealmResults<GitHubRepo>) {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = RepoAdapter(repoList)
        setLoadingFrame(false)
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

    private fun setLoadingFrame(show: Boolean) {
        progress_loading.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun getRxStoreListToUnRegister(): MutableList<RxStore>? {
        return null
    }

    override fun onRxViewRegistered() {
    }

    override fun onRxError(error: RxError) {
        setLoadingFrame(false)
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

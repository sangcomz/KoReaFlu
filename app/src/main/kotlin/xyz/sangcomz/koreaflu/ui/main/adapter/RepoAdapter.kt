package xyz.sangcomz.koreaflu.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.RealmResults
import kotlinx.android.synthetic.main.item_repo.view.*
import xyz.sangcomz.koreaflu.R
import xyz.sangcomz.koreaflu.flux.model.GitHubRepo

/**
 * Created by Seok-Won on 8/31/16.
 */
class RepoAdapter(_repoList: RealmResults<GitHubRepo>) : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    var mRepoList = _repoList

    override fun getItemCount(): Int = mRepoList.count()

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        mRepoList.getOrNull(position)?.let {
            holder?.bindForecast(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bindForecast(repo: GitHubRepo) {
            with(repo) {
                view.text_full_name.text = repo.fullName
                view.text_description.text = repo.description
            }
        }
    }
}
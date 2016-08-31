package xyz.sangcomz.koreaflu.flux.stores

import io.realm.RealmResults
import xyz.sangcomz.koreaflu.flux.model.GitHubRepo

/**
 * Created by Seok-Won on 8/31/16.
 */
interface RepoStoreInterface {
    fun getRepo(): RealmResults<GitHubRepo>?

}
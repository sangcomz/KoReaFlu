package xyz.sangcomz.koreaflu

import android.app.Application
import com.hardsoftstudio.rxflux.RxFlux
import com.hardsoftstudio.rxflux.util.LogLevel
import io.realm.Realm
import io.realm.RealmConfiguration
import xyz.sangcomz.koreaflu.flux.actions.GitHubActionCreator

/**
 * Created by Seok-Won on 8/30/16.
 */
class App : Application() {

    private var rxFlux: RxFlux? = null
    private var githubActionCreator: GitHubActionCreator? = null

    override fun onCreate() {
        super.onCreate()
        initFlux()
        initGitHubActionCreator()
        initRealm()
    }

    fun initFlux() {
        RxFlux.LOG_LEVEL = if (BuildConfig.DEBUG) LogLevel.FULL else LogLevel.NONE
        rxFlux = RxFlux.init(this)
    }

    fun initGitHubActionCreator() {
        rxFlux?.let {
            githubActionCreator = GitHubActionCreator(it.dispatcher, it.subscriptionManager)
        }
    }

    fun initRealm() {
        val config = RealmConfiguration
                .Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }

    fun getGitHubActionCreator() = githubActionCreator

    fun getRxFlux() = rxFlux
}
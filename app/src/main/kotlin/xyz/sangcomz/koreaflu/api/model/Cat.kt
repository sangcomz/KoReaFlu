package xyz.sangcomz.koreaflu.api.model

import io.realm.RealmObject

/**
 * Created by Seok-Won on 8/30/16.
 */

open class Cat : RealmObject() {
    open var name: String? = null
}
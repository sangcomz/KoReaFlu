package xyz.sangcomz.koreaflu.flux.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by marcel on 09/10/15.
 */
@RealmClass
open class GitHubRepo : RealmObject() {

    @PrimaryKey
    open var id: Int = 0
    open var name: String? = null
    open @SerializedName("full_name") var fullName: String? = null
    open var description: String? = null
}

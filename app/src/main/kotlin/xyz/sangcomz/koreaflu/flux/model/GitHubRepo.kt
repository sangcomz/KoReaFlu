package xyz.sangcomz.koreaflu.flux.model

import com.google.gson.annotations.SerializedName

/**
 * Created by marcel on 09/10/15.
 */
class GitHubRepo {

    var id: Int = 0
    var name: String? = null
    @SerializedName("full_name") val fullName: String? = null
    val owner: GitHubUser? = null
    var description: String? = null
}

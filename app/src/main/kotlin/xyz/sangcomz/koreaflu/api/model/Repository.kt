package xyz.sangcomz.koreaflu.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Seok-Won on 8/30/16.
 */
data class Repository(val id: Int,

                      val name: String,

                      @SerializedName("full_name")
                      val fullName: String,

                      val owner: Owner,

                      val language: String,

                      @SerializedName("stargazers_count")
                      val stargazersCount: Long,

                      @SerializedName("watchers_count")
                      val watchersCount: Long,

                      @SerializedName("forks_count")
                      val forksCount: Long) : Comparable<Repository> {

    override fun compareTo(other: Repository): Int {
        return (other.stargazersCount - this.stargazersCount).toInt()
    }
}